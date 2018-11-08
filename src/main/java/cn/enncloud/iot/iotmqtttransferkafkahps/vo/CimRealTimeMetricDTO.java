package cn.enncloud.iot.iotmqtttransferkafkahps.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * cim化实时量测数据
 *
 * @author lifeia
 * @date 2018/7/12.
 */
public class CimRealTimeMetricDTO {
    /**
     * 数据包格式版本.
     */
    private String version;

    /**
     * 站点唯一标识.
     */
    private String staId;

    /**
     * 包中点数.
     */
    private String allPoints;

    /**
     * 数据来源比如泛能站/售电/光伏.
     */
    private String domain;

    /**
     * 上传采集点数据列表.
     */
    private List<MetricData> data;

    public CimRealTimeMetricDTO() {
        data = new ArrayList<MetricData>();
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

    public String getAllPoints() {
        return allPoints;
    }

    public void setAllPoints(String allPoints) {
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

    public class MetricData {
        /**
         * The metric.
         */
        private String metric;

        /**
         * The value.
         */
        private String value;

        /**
         * The time.
         */
        private Long time;

        public String getMetric() {
            return metric;
        }

        public void setMetric(String metric) {
            this.metric = metric;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Long getTime() {
            return time;
        }

        public void setTime(Long time) {
            this.time = time;
        }
    }
}
