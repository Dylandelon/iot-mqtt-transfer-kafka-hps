package cn.enncloud.iot.iotmqtttransferkafkahps.dto;

import org.springframework.stereotype.Component;

/**
 * Created by zhangdelong on 2018/7/5.
 */
@Component
public class CommonData {

    private String dataName;

    private String dataValue ;

    private String dataNameShort ;


    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

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
}
