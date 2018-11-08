package cn.enncloud.iot.iotmqtttransferkafkahps.vo;


import lombok.ToString;

import java.util.List;

/**
 * CIM化格式
 * Created by sunhongqiang on 2018/1/23.
 */
@ToString
public class CimData {

    //数据包格式版本
    private String version;

    //站点唯一标识
    private String staId;

    //包中点数 (传输格式int)
    private int allPoints;

    //数据来源
    private String domain;

    //metric
    private List<CimMetricData> data;

    public CimData() {
    }

    public CimData(String version, String staId, int allPoints, String domain, List<CimMetricData> data) {
        this.version = version;
        this.staId = staId;
        this.allPoints = allPoints;
        this.domain = domain;
        this.data = data;
    }

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

    public List<CimMetricData> getData() {
        return data;
    }

    public void setData(List<CimMetricData> data) {
        this.data = data;
    }


}
