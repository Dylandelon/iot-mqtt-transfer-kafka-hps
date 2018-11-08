package cn.enncloud.iot.iotmqtttransferkafkahps.vo;

import java.util.List;

/**
 * Created by Tony on 2017/8/15.
 */
public class MqttDataItem {
	
	private Long z;       //agentID
	
	private List <DeviceData> y;         //JSONArray
	
	public Long getZ ( ) {
		return z;
	}
	
	public void setZ ( Long z ) {
		this.z = z;
	}
	
	public List <DeviceData> getY ( ) {
		return y;
	}
	
	public void setY ( List <DeviceData> y ) {
		this.y = y;
	}
}
