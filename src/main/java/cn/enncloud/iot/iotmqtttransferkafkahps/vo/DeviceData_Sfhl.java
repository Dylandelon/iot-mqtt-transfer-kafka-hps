package cn.enncloud.iot.iotmqtttransferkafkahps.vo;

import java.util.List;

/**
 * Created by houkang on 2018/7/9.
 */
public class DeviceData_Sfhl {

    private String d;      //deviceID

    private Long t;     //数据采集的时间戳

    private List <List< Object >> c;     //JSONArray包含多个数据项的数据   数据[100,  ---数据项ID  200,  ---数据项的值 g     ---数据质量]


    public String getD ( ) {
        return d;
    }

    public void setD ( String d ) {
        this.d = d;
    }

    public Long getT ( ) {
        return t;
    }

    public void setT ( Long t ) {
        this.t = t;
    }

    public List < List < Object > > getC ( ) {
        return c;
    }

    public void setC ( List < List < Object > > c ) {
        this.c = c;
    }
}
