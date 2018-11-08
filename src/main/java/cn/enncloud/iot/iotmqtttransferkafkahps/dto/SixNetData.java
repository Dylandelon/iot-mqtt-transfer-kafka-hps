package cn.enncloud.iot.iotmqtttransferkafkahps.dto;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by houkang on 2018/7/5.
 */
@Component
public class SixNetData implements Serializable{


    private BigInteger deviceId;

    private String metric;

    private BigInteger did;//网关配置中的设备id

    private BigInteger itemId;    //网关数据项id

    private Integer devType;   //设备类型

    private String deviceName;  //设备名称

    private BigInteger orgId; //组织id

    private String attrGroup; //设备分类

    public BigInteger getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(BigInteger deviceId) {
        this.deviceId = deviceId;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public BigInteger getDid() {
        return did;
    }

    public void setDid(BigInteger did) {
        this.did = did;
    }

    public BigInteger getItemId() {
        return itemId;
    }

    public void setItemId(BigInteger itemId) {
        this.itemId = itemId;
    }

    public Integer getDevType() {
        return devType;
    }

    public void setDevType(Integer devType) {
        this.devType = devType;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public BigInteger getOrgId() {
        return orgId;
    }

    public void setOrgId(BigInteger orgId) {
        this.orgId = orgId;
    }

    public String getAttrGroup() {
        return attrGroup;
    }

    public void setAttrGroup(String attrGroup) {
        this.attrGroup = attrGroup;
    }

  @Override
  public String toString() {
    return "SixNetData{" +
      "deviceId=" + deviceId +
      ", metric='" + metric + '\'' +
      ", did=" + did +
      ", itemId=" + itemId +
      ", devType=" + devType +
      ", deviceName='" + deviceName + '\'' +
      ", orgId=" + orgId +
      ", attrGroup='" + attrGroup + '\'' +
      '}';
  }
}
