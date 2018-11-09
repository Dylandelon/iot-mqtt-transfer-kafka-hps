package cn.enncloud.iot.iotmqtttransferkafkahps.service.impl;


import cn.enncloud.iot.iotmqtttransferkafkahps.dto.SixNetData;
import cn.enncloud.iot.iotmqtttransferkafkahps.service.IDataCacheService;
import cn.enncloud.iot.iotmqtttransferkafkahps.service.IMessageProcessService;
import cn.enncloud.iot.iotmqtttransferkafkahps.utils.JsonUtils;
import cn.enncloud.iot.iotmqtttransferkafkahps.vo.MetricData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
        Map<String, String> commonMap = dataCacheService.getCommonData();
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
              ctMetricData.setMetric(commonMap.get(mapping.getDevType() + "") + "_" + devId + "_" + metric);
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
