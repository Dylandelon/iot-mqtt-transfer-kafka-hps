package cn.enncloud.iot.iotmqtttransferkafkahps.service;

import cn.enncloud.iot.iotmqtttransferkafkahps.dto.AnyLinkData;
import cn.enncloud.iot.iotmqtttransferkafkahps.dto.CommonData;
import cn.enncloud.iot.iotmqtttransferkafkahps.dto.SixNetData;

import java.util.List;
import java.util.Map;

public interface IDataCacheService {
    void deleteWithkeys();
    long deleteWithAgentId(String hk);
    List<AnyLinkData> getAnyLinkPointByAgentId(String agentId);
    List<SixNetData> getByAgentId(String agentId);
    Map<String, String> getCommonData();
    Object getByOrgId(Long orgid);
    List<CommonData> getCommonDataList();
}
