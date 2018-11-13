package cn.enncloud.iot.iotmqtttransferkafkahps.service.impl;


import cn.enncloud.iot.iotmqtttransferkafkahps.dto.CommonData;
import cn.enncloud.iot.iotmqtttransferkafkahps.dto.SixNetData;
import cn.enncloud.iot.iotmqtttransferkafkahps.service.IDataCacheService;
import cn.enncloud.iot.iotmqtttransferkafkahps.service.IMessageProcessService;
import cn.enncloud.iot.iotmqtttransferkafkahps.utils.JsonUtils;
import cn.enncloud.iot.iotmqtttransferkafkahps.vo.MetricData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhangdelong on 2018/7/4.
 */
@Slf4j
@Service(value = "SixNetDataExecuteServiceImpl")
public class SixNetDataExecuteServiceImpl implements IMessageProcessService {

  @Autowired
  private IDataCacheService dataCacheService;

  @Override
  public Map<Long, List<MetricData>> execute(String json) {


    Map<Long, List<MetricData>> resultMap = new HashMap<>();
    Date time = new Date();
    try {
      //解析json
      Map dataItem = JsonUtils.readObject(json, Map.class);
      if (dataItem != null && dataItem.containsKey("d")) {
        Map diteamMap = (Map) dataItem.get("d");
        String ts = (String) dataItem.get("ts");
        try {
          time = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss+SSSS").parse(ts);
        } catch (Exception e) {
          log.error("获取sixnet时间转换错误" + ts, e);
        }
//        Map<String, String> commonMap = dataCacheService.getCommonData();
        List<CommonData> commonDataList = dataCacheService.getCommonDataList();
        Set<String> agentIdset = diteamMap.keySet();
        //获取网关编码
        for (String keystr : agentIdset) {
          //根据网关编码获取设备和属性信息
          List<SixNetData> dataList = dataCacheService.getByAgentId(keystr);
          if(CollectionUtils.isEmpty(dataList)){
            return null;
          }
          Map submap = (Map) diteamMap.get(keystr);
          Map<String, String> itemMap = (Map) submap.get("Val");
          Set<String> itemset = itemMap.keySet();

          Map<String,SixNetData> dataMap = new HashMap<>();
          for(SixNetData ad : dataList){
            dataMap.put(ad.getDeviceId()+"_"+ad.getItemId()+"",ad);
          }

          //解析数据对象
          for (String itemid : itemset) {
            SixNetData mapping = dataMap.get(itemid);
            String dataValue = String.valueOf(itemMap.get(itemid));
            if (mapping != null) {

              String metric = mapping.getMetric();     //指标名称
              String devId = mapping.getDeviceId().toString();

              MetricData ctMetricData = new MetricData();
              for (CommonData commonData:commonDataList) {
                if(commonData.getDataValue().equalsIgnoreCase(mapping.getDevType() + "")){

                  String metri = commonData.getDataNameShort() + "_" + devId + "_" + metric;
                  String newMetir ="["+commonData.getCimDataName()+"]_["+mapping.getDevCimId()+"]_["+mapping.getCimPath()+"]";
                  //              ctMetricData.setMetric(commonMap.get(mapping.getDevType() + "") + "_" + devId + "_" + metric);
//                  ctMetricData.setMetric(commonMap.get(mapping.getDevType() + "") + "_" + devId + "_" + metric+"-"+itemid);

//                  ctMetricData.setMetric(newMetir+"；原始报文网关："+keystr+"对应表dev_gateway.serialnumber ；设备："+itemid+"对应表dev_device.id_dev_model_phyattribute.id；原cim点"+metri+":对应common_data.data_name_short_dev_device.id_dev_model_phyattribute.target_path；设备序列号："+mapping.getSerialnumber()+"对应dev_device.serialnumber；" +
//                          "新增cim2.0映射对应:common_data.cim_Data_Name_dev_device.dev_cim_id_dev_model_phyattribute.cimPath。common_data、dev_devicedev_model_phyattribute对应主键id依次是："+commonData.getId()+"!"+mapping.getDeviceId()+"!"+mapping.getItemId());

                  if(StringUtils.isEmpty(commonData.getCimDataName()) || StringUtils.isEmpty(mapping.getDevCimId()) || StringUtils.isEmpty(mapping.getCimPath())){

                    log.error(newMetir+"；原始报文网关："+keystr+"对应表dev_gateway.serialnumber ；设备："+itemid+"对应表dev_device.id_dev_model_phyattribute.id；原cim点"+metri+":对应common_data.data_name_short_dev_device.id_dev_model_phyattribute.target_path；设备序列号："+mapping.getSerialnumber()+"对应dev_device.serialnumber；" +
                            "新增cim2.0映射对应:common_data.cim_Data_Name_dev_device.dev_cim_id_dev_model_phyattribute.cimPath。common_data、dev_devicedev_model_phyattribute对应主键id依次是："+commonData.getId()+"!"+mapping.getDeviceId()+"!"+mapping.getItemId());
                    return null;
                  }else{

                    ctMetricData.setMetric(commonData.getCimDataName()+"_"+mapping.getDevCimId()+"_"+mapping.getCimPath());
                  }

                  break;
                }

              }

              ctMetricData.setTime(time.getTime());
              ctMetricData.setValue(dataValue);
              Long orgid = mapping.getOrgId().longValue();
              if (resultMap.containsKey(orgid)) {
                resultMap.get(orgid).add(ctMetricData);
              } else {
                List<MetricData> metlist = new ArrayList<MetricData>();
                metlist.add(ctMetricData);
                resultMap.put(orgid, metlist);
              }
            }
          }
        }
      }
    } catch (Exception ex) {
      log.error("获取sixnet关联信息异常", ex);
    }
    return resultMap;
  }

}
