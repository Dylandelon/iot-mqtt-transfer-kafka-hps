package cn.enncloud.iot.iotmqtttransferkafkahps.service.impl;


import cn.enncloud.iot.iotmqtttransferkafkahps.dto.AnyLinkData;
import cn.enncloud.iot.iotmqtttransferkafkahps.dto.CommonData;
import cn.enncloud.iot.iotmqtttransferkafkahps.service.IDataCacheService;
import cn.enncloud.iot.iotmqtttransferkafkahps.service.IMessageProcessService;
import cn.enncloud.iot.iotmqtttransferkafkahps.utils.JsonUtils;
import cn.enncloud.iot.iotmqtttransferkafkahps.vo.DeviceData;
import cn.enncloud.iot.iotmqtttransferkafkahps.vo.MetricData;
import cn.enncloud.iot.iotmqtttransferkafkahps.vo.MqttDataItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangdelong on 2018/7/4.
 */
@Slf4j
@Service(value = "AnyLinkDataExecuteServiceImpl")
public class AnyLinkDataExecuteServiceImpl implements IMessageProcessService {

  private static final String MASK_PRE = "mask-0x";

  private static final int STR_HEX_LEN = 4;
  @Autowired
  private IDataCacheService dataCacheService;


  @Override
  public Map<Long, List<MetricData>> execute(String json) {
    MqttDataItem dataItem = null;
    try {
      dataItem = JsonUtils.readObject(json, MqttDataItem.class);
    } catch (Exception e) {
      log.error("json解析错误，json=" + json);
    }
    if (dataItem == null) {
      return null;
    }

//    Map<String, String> commonMap = dataCacheService.getCommonData();
    List<CommonData> commonDataList = dataCacheService.getCommonDataList();

    Long agentId = dataItem.getZ();      //获取网关序列号
    List<AnyLinkData> pointData = dataCacheService.getAnyLinkPointByAgentId(agentId.toString());
    Map<Long, List<MetricData>> resultMap = new HashMap<>();
    for (DeviceData deviceData : dataItem.getY()) {
      //组织场站 数据
      Long time = deviceData.getT();            //获取时间戳
      Long deviceId = deviceData.getD();       //获取设备ID
      try {
        if(CollectionUtils.isEmpty(pointData)){
          return null;
        }else {
          Map<String,AnyLinkData> anyLinkDataMap = new HashMap();
          pointData.stream().forEach(item ->{
            anyLinkDataMap.put(item.getDid()+"-"+item.getItemId(),item);
          });

          for (List<Object> list : deviceData.getC()) {
            Long itemId = Long.valueOf(list.get(0).toString());       //获取itemID
            String dataValue = list.get(1).toString();           //获取数据项的值

            AnyLinkData anyLinkData =  anyLinkDataMap.get(deviceId+"-"+itemId);
            if (null != anyLinkData) {
              String metric = anyLinkData.getMetric();     //指标名称
              String devId = anyLinkData.getDeviceId().toString();
              if (anyLinkData.getMaskCode() != null && anyLinkData.getMaskCode().startsWith(MASK_PRE)) {
                try {
                  String mask = anyLinkData.getMaskCode().replace(MASK_PRE, "");
                  String maskB = hexStrToBinaryStr(strLength(mask));
                  if (dataValue != null) {
                    int dataint = Integer.parseInt(dataValue);
                    String valueB = decimalToBinary(dataint);
                    dataValue = checkAlarm(valueB, maskB);
                  }
                } catch (Exception e) {
                  log.error("转换anyLink掩码信息异常", e);
                }

              }
              MetricData ctMetricData = new MetricData();


              for (CommonData commonData:commonDataList) {

                if(commonData.getDataValue().equalsIgnoreCase(anyLinkData.getDevType()+"")){

                  String metri = commonData.getDataNameShort() + "_" + devId + "_" + metric;
                  String newMetir ="["+commonData.getCimDataName()+"]_["+anyLinkData.getDevCimId()+"]_["+anyLinkData.getCimPath()+"]";
//              ctMetricData.setMetric(commonMap.get(anyLinkData.getDevType() + "") + "_" + devId + "_" + metric);
//                  ctMetricData.setMetric("原始报文网关："+agentId.toString()+"对应表dev_anylink_dataitem_mapping.agent_id ，设备："+deviceId+"-"+itemId+"对应表dev_device.gateway_dev_num-dev_anylink_dataitem_mapping.item_id,点"+metri+":对应common_data.data_name_short_dev_device.id_dev_model_phyattribute.target_path，设备序列号："+anyLinkData.getSerialnumber()+"对应dev_device.serialnumber," +
//                          "新增cim2.0映射对应"+newMetir+":common_data.cim_Data_Name_dev_device.dev_cim_id_dev_model_phyattribute.cimPath。");
//                  ctMetricData.setMetric(newMetir+"；原始报文网关："+agentId.toString()+"对应表dev_anylink_dataitem_mapping.agent_id ；设备："+deviceId+"-"+itemId+"对应表dev_device.gateway_dev_num-dev_anylink_dataitem_mapping.item_id；原cim点"+metri+":对应common_data.data_name_short_dev_device.id_dev_model_phyattribute.target_path；设备序列号："+anyLinkData.getSerialnumber()+"对应dev_device.serialnumber；" +
//                          "新增cim2.0映射对应:common_data.cim_Data_Name_dev_device.dev_cim_id_dev_model_phyattribute.cimPath。common_data、dev_devicedev_model_phyattribute对应主键id依次是："+commonData.getId()+"!"+anyLinkData.getDeviceId()+"!"+anyLinkData.getItemId());
                  if(StringUtils.isEmpty(commonData.getCimDataName()) || StringUtils.isEmpty(anyLinkData.getDevCimId()) || StringUtils.isEmpty(anyLinkData.getCimPath())){

                    log.error(newMetir+"；原始报文网关："+agentId.toString()+"对应表dev_anylink_dataitem_mapping.agent_id ；设备："+deviceId+"-"+itemId+"对应表dev_device.gateway_dev_num-dev_anylink_dataitem_mapping.item_id；原cim点"+metri+":对应common_data.data_name_short_dev_device.id_dev_model_phyattribute.target_path；设备序列号："+anyLinkData.getSerialnumber()+"对应dev_device.serialnumber；" +
                            "新增cim2.0映射对应:common_data.cim_Data_Name_dev_device.dev_cim_id_dev_model_phyattribute.cimPath。common_data、dev_devicedev_model_phyattribute对应主键id依次是："+commonData.getId()+"!"+anyLinkData.getDeviceId()+"!"+anyLinkData.getItemId());
                    return null;
                  }else{
                    ctMetricData.setMetric(commonData.getCimDataName()+"_"+anyLinkData.getDevCimId()+"_"+anyLinkData.getCimPath());
                  }


                  break;
                }
              }


              ctMetricData.setTime(time);
              ctMetricData.setValue(dataValue);
              Long orgid = anyLinkData.getOrgId().longValue();
              if (resultMap.containsKey(orgid)) {
                resultMap.get(orgid).add(ctMetricData);
              } else {
                List<MetricData> metlist = new ArrayList<>();
                metlist.add(ctMetricData);
                resultMap.put(orgid, metlist);
              }
            }
          }
        }
      } catch (Exception ex) {
        log.error("获取anyLink关联信息异常", ex);
      }
    }
    return resultMap;
  }


  /**
   * 十进制转二进制
   */
  public static String decimalToBinary(int decimalSource) {
    BigInteger bi = new BigInteger(String.valueOf(decimalSource));  //转换成BigInteger类型
    StringBuffer binaryStr = new StringBuffer(bi.toString(2));  //参数2指定的是转化成X进制，默认10进制
    while (binaryStr.length() < 16) {
      binaryStr.insert(0, "0");
    }
    return binaryStr.toString();
  }


  /**
   * 补充字符串长度
   *
   * @param source 原始字符串
   * @return
   */
  private static String strLength(String source) {
    StringBuffer sb = new StringBuffer(source);
    while (sb.length() < STR_HEX_LEN) {
      sb.insert(0, "0");
    }
    return sb.toString();
  }

  /**
   * 十六进制字符串转为二进制字符串
   *
   * @param hexString 待转换的十六进制字符串
   * @return
   */
  private static String hexStrToBinaryStr(String hexString) {
    if (hexString == null || hexString.equals("")) {
      return null;
    }
    StringBuffer sb = new StringBuffer();
    // 将每一个十六进制字符分别转换成一个四位的二进制字符
    for (int i = 0; i < hexString.length(); i++) {
      String indexStr = hexString.substring(i, i + 1);
      StringBuffer binaryStr = new StringBuffer(Integer.toBinaryString(Integer.parseInt(indexStr, 16)));
      while (binaryStr.length() < STR_HEX_LEN) {
        binaryStr.insert(0, "0");
      }
      sb.append(binaryStr);
    }
    return sb.toString();
  }


  /**
   * 判断是否需要报警
   */
  public String checkAlarm(String valueB, String maskB) {
    String[] valueBarr = valueB.split("");
    String[] maskBarr = maskB.split("");
    for (int i = 0; i < maskBarr.length; i++) {
      if ("1".equals(maskBarr[i]) && "0".equals(valueBarr[i])) {
        return "0";
      }
    }

    return "1";
  }


}
