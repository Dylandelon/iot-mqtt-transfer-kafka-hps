package cn.enncloud.iot.iotmqtttransferkafkahps.service;


import cn.enncloud.iot.iotmqtttransferkafkahps.dto.AnyLinkData;
import cn.enncloud.iot.iotmqtttransferkafkahps.dto.SixNetData;
import cn.enncloud.iot.iotmqtttransferkafkahps.dto.TopicData;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangdelong on 2017/8/22.
 */
public interface IQueryDataPoinService {

    TopicData getTopicDataByType(Long orgId);

    /**
     * 获取采集点
     * @param agentId
     * @return
     */
    List<SixNetData> queryDeviceDataByAgentId(String agentId);


    /**
     * 获取业务域
     * @return
     */
    Map<String,String> queryRedisCommonData();
    List<AnyLinkData> findByAgentId(String agentId);
}
