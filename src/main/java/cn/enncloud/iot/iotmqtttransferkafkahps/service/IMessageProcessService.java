package cn.enncloud.iot.iotmqtttransferkafkahps.service;


import cn.enncloud.iot.iotmqtttransferkafkahps.vo.MetricData;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangdelong on 2018/7/4.
 */
public interface IMessageProcessService {

    Map<Long, List<MetricData>> execute(String json);

}
