package cn.enncloud.iot.iotmqtttransferkafkahps.repository;


import cn.enncloud.iot.iotmqtttransferkafkahps.dto.AnyLinkData;
import cn.enncloud.iot.iotmqtttransferkafkahps.dto.CommonData;
import cn.enncloud.iot.iotmqtttransferkafkahps.dto.SixNetData;
import cn.enncloud.iot.iotmqtttransferkafkahps.dto.TopicData;

import java.util.List;

/**
 * Created by Tony on 2017/8/22.
 */
public interface AnyLinkDataItemMappingDao {

    List<AnyLinkData> findByAgentId(String agentId);

    TopicData getTopicDataByType(Long orgId);

    List<SixNetData> queryDeviceDataByAgentId(String agentId);

    List<CommonData> queryCommonData(String dateType);
}
