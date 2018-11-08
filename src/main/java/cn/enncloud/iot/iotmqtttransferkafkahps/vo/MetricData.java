package cn.enncloud.iot.iotmqtttransferkafkahps.vo;


import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.util.StringUtils;

/**
 * kafka统一格式数据
 * Created by lixiangk on 2017/7/26.
 */
@ToString
@Data
public class MetricData {

    private String deviceId;
    private String metric;
    private String value;
    private Long time;

    public MetricData() {
    }

    public MetricData(String deviceId, String metric, String value, Long time) {
        this.deviceId = deviceId;
        this.metric = metric;
        this.value = value;
        this.time = time;
    }


    /**
     * 检查数值是否合法
     *
     * @return true or false
     */
    public boolean validate() {
        if (StringUtils.isEmpty(deviceId)
                || StringUtils.isEmpty(metric)
                || !NumberUtils.isDigits(deviceId)
                || value == null
                || time == null) {
            return false;
        }
        return true;
    }



}