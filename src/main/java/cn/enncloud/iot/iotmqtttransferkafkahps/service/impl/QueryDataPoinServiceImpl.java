package cn.enncloud.iot.iotmqtttransferkafkahps.service.impl;

import cn.enncloud.iot.iotmqtttransferkafkahps.dto.AnyLinkData;
import cn.enncloud.iot.iotmqtttransferkafkahps.dto.CommonData;
import cn.enncloud.iot.iotmqtttransferkafkahps.dto.SixNetData;
import cn.enncloud.iot.iotmqtttransferkafkahps.dto.TopicData;
import cn.enncloud.iot.iotmqtttransferkafkahps.repository.AnyLinkDataItemMappingDao;
import cn.enncloud.iot.iotmqtttransferkafkahps.service.IQueryDataPoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QueryDataPoinServiceImpl implements IQueryDataPoinService {
    @Autowired
    private AnyLinkDataItemMappingDao dataItemMappingDao;


    @Override
    public TopicData getTopicDataByType(Long orgId) {
        return dataItemMappingDao.getTopicDataByType(orgId);
    }

    @Override
    public List<SixNetData> queryDeviceDataByAgentId(String agentId){
        List<SixNetData> list = dataItemMappingDao.queryDeviceDataByAgentId(agentId);
        return list;
    }


    @Override
    public Map<String, String> queryRedisCommonData() {
        Map<String, String> commonMap;
        commonMap = this.queryCommonData("1");
        return commonMap;
    }
    @Override
    public List<CommonData> queryRedisCommonDataList() {
        return this.queryCommonDataList("1");
    }

    @Override
    public List<AnyLinkData> findByAgentId(String agentId) {
        return dataItemMappingDao.findByAgentId(agentId);
    }


    private Map<String, String> queryCommonData(String dateType) {

        Map<String,String> map = new HashMap<>();
        List<CommonData> listdata =  dataItemMappingDao.queryCommonData(dateType);
        if(listdata!=null && listdata.size()>0){
            for(CommonData c : listdata){
                map.put(c.getDataValue(),c.getDataNameShort());
            }
        }
        return map;
    }
    private List<CommonData> queryCommonDataList(String dateType) {

        List<CommonData> listdata =  dataItemMappingDao.queryCommonData(dateType);
        return listdata;
    }
}
