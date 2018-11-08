package cn.enncloud.iot.iotmqtttransferkafkahps.dto;


import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by Tony on 2017/8/16.
 */
public class AnyLinkData implements Serializable {

	private Long deviceId;

	private String metric;

	private String did;//网关配置中的设备id

    private Long itemId;    //网关数据项id

	private Integer devType;   //设备类型

	private String deviceName;  //设备名称

	private BigInteger orgId; //组织id

	private String attrGroup; //设备分类

	private String maskCode;

	public Long getDeviceId ( ) {
		return deviceId;
	}

	/*public void setDeviceId ( Long deviceId ) {
		this.deviceId = deviceId;
	}*/

	public void setDeviceId(BigInteger deviceId) {this.deviceId = deviceId.longValue();}

	public String getMetric ( ) {
		return metric;
	}

	public void setMetric ( String metric ) {
		this.metric = metric;
	}

    public String getDid() {
        return did;
    }

	public void setDid ( String did ) {
		this.did = did;
    }

    public Long getItemId() {
        return itemId;
    }

	public void setItemId ( Integer itemId ) {
		this.itemId = itemId.longValue();
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

	public String getMaskCode() {
		return maskCode;
	}

  public void setMaskCode(String maskCode) {
    this.maskCode = maskCode;
  }

  @Override
  public String toString() {
    return "AnyLinkData{" +
      "deviceId=" + deviceId +
      ", metric='" + metric + '\'' +
      ", did='" + did + '\'' +
      ", itemId=" + itemId +
      ", devType=" + devType +
      ", deviceName='" + deviceName + '\'' +
      ", orgId=" + orgId +
      ", attrGroup='" + attrGroup + '\'' +
      ", maskCode='" + maskCode + '\'' +
      '}';
  }
}
