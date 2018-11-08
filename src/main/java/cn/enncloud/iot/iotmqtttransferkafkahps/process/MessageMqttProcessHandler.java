package cn.enncloud.iot.iotmqtttransferkafkahps.process;

import cn.enncloud.iot.iotmqtttransferkafkahps.beans.DevGatewayEntity;
import cn.enncloud.iot.iotmqtttransferkafkahps.constant.AdapterProperties;
import cn.enncloud.iot.iotmqtttransferkafkahps.constant.DeviceFactoryConst;
import cn.enncloud.iot.iotmqtttransferkafkahps.dto.TopicData;
import cn.enncloud.iot.iotmqtttransferkafkahps.service.IDataCacheService;
import cn.enncloud.iot.iotmqtttransferkafkahps.service.IDevGatewayService;
import cn.enncloud.iot.iotmqtttransferkafkahps.service.IMessageProcessService;
import cn.enncloud.iot.iotmqtttransferkafkahps.service.IQueryDataPoinService;
import cn.enncloud.iot.iotmqtttransferkafkahps.utils.JsonUtils;
import cn.enncloud.iot.iotmqtttransferkafkahps.vo.CimRealTimeMetricDTO;
import cn.enncloud.iot.iotmqtttransferkafkahps.vo.MessageMain;
import cn.enncloud.iot.iotmqtttransferkafkahps.vo.MetricData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@Component
public class MessageMqttProcessHandler {
    @Autowired
    private IQueryDataPoinService iQueryDataPoinService;
    @Autowired
    private IDataCacheService dataCacheService;
    @Resource
    private MessageChannel output;
    @Autowired
    private AdapterProperties adapterProperties;

    @Qualifier("AnyLinkDataExecuteServiceImpl")
    private IMessageProcessService anyLinkDataExecuteService;
    @Qualifier("SixNetDataExecuteServiceImpl")
    private IMessageProcessService sixNetDataExecuteService;
    @Qualifier("SfhlDataExecuteServiceImpl")
    private IMessageProcessService sfhlDataExecuteService;

    @Autowired
    private IDevGatewayService devGatewayService;

    public void doProcess(Message<?> message){
        try {
            String jsonData = (String)message.getPayload();
            Map<Long,List<MetricData>> itemMainData = null;
            Map dataItem = JsonUtils.readObject(jsonData, Map.class);
            if(dataItem != null && dataItem.containsKey("z")){
                String serialnumber  = (String) dataItem.get("z");
                DevGatewayEntity devGatewayEntity = devGatewayService.findBySerialnumber(serialnumber);
                if(devGatewayEntity.getFirm().equalsIgnoreCase(DeviceFactoryConst.ANYLINK)){

                    itemMainData = anyLinkDataExecuteService.execute(jsonData);
                }else if(devGatewayEntity.getFirm().equalsIgnoreCase(DeviceFactoryConst.SHENGFENGHELI)){
                    itemMainData = sfhlDataExecuteService.execute(jsonData);
                }else {
                    log.error("不能匹配到设备:"+serialnumber);
                }
            }else if(dataItem != null && dataItem.containsKey("ts")){

                itemMainData = sixNetDataExecuteService.execute(jsonData);
            }

            if(!CollectionUtils.isEmpty(itemMainData)){
                Set<Long> orgset = itemMainData.keySet();
                //获取网关编码
                for(Long orgid : orgset){
                    List<MetricData> metlist = itemMainData.get(orgid);
                    MessageMain maindata = new MessageMain();
                    CimRealTimeMetricDTO cimRealTimeMetricDTO = new CimRealTimeMetricDTO();
                    CimRealTimeMetricDTO.MetricData metricData = cimRealTimeMetricDTO.new MetricData();


                    Object obj = dataCacheService.getByOrgId(orgid);
                    TopicData td;
                    if(null == obj){
                        log.error("获取业务域信息为空 orgId:{}",orgid);
                        return;
                    }else {
                        //可以查询到业务域
                        if(obj instanceof TopicData){
                            td = (TopicData) obj;
                            maindata.setStaId(td.getStandId());
                            maindata.setAllPoints(metlist.size());
                            maindata.setData(metlist);
                            maindata.setDomain(td.getDataNameShort());
                            List<CimRealTimeMetricDTO> kafkaMessage =  convertData(maindata);
                            for (CimRealTimeMetricDTO timeMetricDTO:kafkaMessage) {
                                if(!StringUtils.isEmpty(timeMetricDTO.getDomain())){
                                    // todo 注意
//                                    timeMetricDTO.setDomain("HPS");
                                    if(!sendDataToKafka(timeMetricDTO)){
                                        log.error("cim化发送kafka失败"+ JsonUtils.writeValueAsString(timeMetricDTO));
                                    }
                                }

                            }
                        }
                    }
                }
            }else{
                if(log.isErrorEnabled()){
                    log.error("解析数据为空，topic:{},jsonData====:{}","allInOne",jsonData);
                }
            }

        }catch (Exception e){
            log.error("mqtt thread handler exception:{}",e);
        }
    }
    private List<CimRealTimeMetricDTO> convertData(MessageMain  realTimeResult){
        CimRealTimeMetricDTO cimRealTimeMetricDTO = new CimRealTimeMetricDTO();
        List<CimRealTimeMetricDTO.MetricData> metricDataList = new ArrayList<>(realTimeResult.getData().size());
        realTimeResult.getData().forEach(realMetric -> {
            CimRealTimeMetricDTO.MetricData metricData = cimRealTimeMetricDTO.new MetricData();
            metricData.setMetric(realMetric.getMetric());
            metricData.setTime(realMetric.getTime());
            metricData.setValue(realMetric.getValue());
            metricDataList.add(metricData);
        });
        // 数据分组，每组固定数量量测点
        int packageSize = (int) Math.ceil((double) metricDataList.size() / adapterProperties.getPakageSize());
        List<CimRealTimeMetricDTO> packages = new ArrayList<>(packageSize);
        for (int i = 0; i < packageSize; i++) {
            CimRealTimeMetricDTO cimRealTimeMetricDTOCIM = new CimRealTimeMetricDTO();

            List<CimRealTimeMetricDTO.MetricData> packageMetrics;
            if (i == packageSize - 1) {
                packageMetrics = metricDataList.subList(i * adapterProperties.getPakageSize(), metricDataList.size());
            } else {
                packageMetrics = metricDataList.subList(i * adapterProperties.getPakageSize(), (i + 1) * adapterProperties.getPakageSize());
            }
            cimRealTimeMetricDTOCIM.setAllPoints(String.valueOf(packageMetrics.size()));
            cimRealTimeMetricDTOCIM.setDomain(realTimeResult.getDomain());
            cimRealTimeMetricDTOCIM.setData(packageMetrics);
            cimRealTimeMetricDTOCIM.setStaId(realTimeResult.getStaId());
            cimRealTimeMetricDTOCIM.setVersion(realTimeResult.getVersion());
            packages.add(cimRealTimeMetricDTOCIM);
        }

        return packages;
    }
    /**
     * 发送数据到kafka
     */
    private boolean sendDataToKafka(CimRealTimeMetricDTO kafkaData) throws Exception {

        return this.output.send(MessageBuilder.withPayload(kafkaData).build());
    }
}
