package cn.enncloud.iot.iotmqtttransferkafkahps.service.impl;


import cn.enncloud.iot.iotmqtttransferkafkahps.dto.SixNetData;
import cn.enncloud.iot.iotmqtttransferkafkahps.service.IDataCacheService;
import cn.enncloud.iot.iotmqtttransferkafkahps.service.IMessageProcessService;
import cn.enncloud.iot.iotmqtttransferkafkahps.utils.JsonUtils;
import cn.enncloud.iot.iotmqtttransferkafkahps.vo.DeviceData_Sfhl;
import cn.enncloud.iot.iotmqtttransferkafkahps.vo.MetricData;
import cn.enncloud.iot.iotmqtttransferkafkahps.vo.MqttDataItem_Sfhl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by houkang on 2018/7/5.
 */
@Slf4j
@Service(value = "SfhlDataExecuteServiceImpl")
public class SfhlDataExecuteServiceImpl implements IMessageProcessService {

  @Autowired
  private IDataCacheService dataCacheService;


  @Override
  public Map<Long, List<MetricData>> execute(String json) {
    MqttDataItem_Sfhl dataItem = null;
    try {
      dataItem = JsonUtils.readObject(json, MqttDataItem_Sfhl.class);
    } catch (Exception e) {
      log.error("json解析错误，json=" + json);
    }
    if (dataItem == null) {
      return null;
    }


    Map<String, String> commonMap = dataCacheService.getCommonData();
    //获取网关序列号
    String agentId = dataItem.getZ();
    List<SixNetData>  dataList = dataCacheService.getByAgentId(agentId);
    if(CollectionUtils.isEmpty(dataList)){
      return null;
    }
    Map<String,SixNetData> dataMap = new HashMap<>();
    for(SixNetData ad : dataList){
      dataMap.put(ad.getDeviceId()+"_"+ad.getItemId()+"",ad);
    }

    Map<Long, List<MetricData>> resultMap = new HashMap<>();
    for (DeviceData_Sfhl deviceData : dataItem.getY()) {
      //组织场站 数据
      Long time = deviceData.getT();
      try {
        for (List<Object> list : deviceData.getC()) {
          String itemId = list.get(0).toString();       //获取itemID
          String dataValue = list.get(1).toString();           //获取数据项的值

          SixNetData mapping = dataMap.get(itemId);
          if (mapping != null) {

            String metric = mapping.getMetric();     //指标名称
            String devId = mapping.getDeviceId().toString();

            MetricData ctMetricData = new MetricData();
            ctMetricData.setMetric(commonMap.get(mapping.getDevType() + "") + "_" + devId + "_" + metric);
            ctMetricData.setTime(time);
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

      } catch (Exception ex) {
        log.error("获取anyLink关联信息异常", ex);
      }
    }
    return resultMap;
  }
}
