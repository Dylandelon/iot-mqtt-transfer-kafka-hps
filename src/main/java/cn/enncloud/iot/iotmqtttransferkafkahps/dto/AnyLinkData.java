package cn.enncloud.iot.iotmqtttransferkafkahps.dto;


import lombok.ToString;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by zhangdelong on 2017/8/16.
 */
@ToString
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
//	private String cimDataName ; //1
	private String devCimId  ; //2
	private String cimPath; //3
	private String serialnumber;

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

	public String getSerialnumber() {
		return serialnumber;
	}

	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}


	public String getDevCimId() {
		return devCimId;
	}

	public void setDevCimId(String devCimId) {
		this.devCimId = devCimId;
	}

	public String getCimPath() {
		return cimPath;
	}

	public void setCimPath(String cimPath) {
		this.cimPath = cimPath;
	}
}
