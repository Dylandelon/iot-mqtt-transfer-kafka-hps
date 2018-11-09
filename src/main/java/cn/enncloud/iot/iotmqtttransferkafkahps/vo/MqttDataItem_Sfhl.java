package cn.enncloud.iot.iotmqtttransferkafkahps.vo;

import java.util.List;

/**
 * Created by zhangdelong on 2018/7/9.
 */
public class MqttDataItem_Sfhl {

    private String z;       //agentID

    private List< DeviceData_Sfhl > y;         //JSONArray

    public String getZ() {
        return z;
    }

    public void setZ(String z) {
        this.z = z;
    }

    public List<DeviceData_Sfhl> getY() {
        return y;
    }

    public void setY(List<DeviceData_Sfhl> y) {
        this.y = y;
    }
}
