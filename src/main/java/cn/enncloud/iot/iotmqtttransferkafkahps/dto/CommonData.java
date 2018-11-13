package cn.enncloud.iot.iotmqtttransferkafkahps.dto;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by zhangdelong on 2018/7/5.
 */
@Component
public class CommonData implements Serializable {

    private Long id;
    private String dataName;

    private String dataValue ;

    private String dataNameShort ;
    private String cimDataName ; //1


    public Long getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id.longValue();
    }

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

    public String getCimDataName() {
        return cimDataName;
    }

    public void setCimDataName(String cimDataName) {
        this.cimDataName = cimDataName;
    }
}
