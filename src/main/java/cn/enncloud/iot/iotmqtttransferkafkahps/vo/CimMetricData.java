package cn.enncloud.iot.iotmqtttransferkafkahps.vo;

/**
 * CIM中metric格式
 * Created by sunhongqiang on 2018/1/23.
 */
public class CimMetricData {

    //后3单元为设备名_设备id_属性
    private String metric;

    private Object value;

    private long time;

    public CimMetricData() {
    }

    public CimMetricData(String metric, Object value, long time) {
        this.metric = metric;
        this.value = value;
        this.time = time;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
