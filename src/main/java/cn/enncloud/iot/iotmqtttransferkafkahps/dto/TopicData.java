package cn.enncloud.iot.iotmqtttransferkafkahps.dto;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by houkang on 2018/4/12.
 */
@Component
public class TopicData implements Serializable{

    private String dataValue;  //业务域的值

    private String dataNameShort;  //业务域的 简称

    private String dataTopic; // 大数据中用的业务域

    private Long deviceType;  //业务域类型

    private String  standId;  //站点

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public String getDataNameShort() {
        return dataNameShort;
    }

    public void setDataNameShort(String dataNameShort) {
        this.dataNameShort = dataNameShort;
    }

    public String getDataTopic() {
        return dataTopic;
    }

    public void setDataTopic(String dataTopic) {
        this.dataTopic = dataTopic;
    }

    public Long getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Long deviceType) {
        this.deviceType = deviceType;
    }

    public String getStandId() {
        return standId;
    }

    public void setStandId(String standId) {
        this.standId = standId;
    }
}
