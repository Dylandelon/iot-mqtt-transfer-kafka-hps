package cn.enncloud.iot.iotmqtttransferkafkahps.vo;

import java.util.List;

/**
 * Created by zhangdelong on 2018/4/2.
 */
public class MessageMain {

    
    private String version = "1"; //数据包格式版本

    private String staId; //站点唯一标识

    private int  allPoints;  //包中点数 (传输格式int)

    private String domain;  //数据来源比如泛能站、售电

    private List<MetricData> data;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStaId() {
        return staId;
    }

    public void setStaId(String staId) {
        this.staId = staId;
    }

    public int getAllPoints() {
        return allPoints;
    }

    public void setAllPoints(int allPoints) {
        this.allPoints = allPoints;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public List<MetricData> getData() {
        return data;
    }

    public void setData(List<MetricData> data) {
        this.data = data;
    }


}
