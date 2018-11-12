package cn.enncloud.iot.iotmqtttransferkafkahps.service.impl;

import cn.enncloud.iot.iotmqtttransferkafkahps.constant.AdapterProperties;
import cn.enncloud.iot.iotmqtttransferkafkahps.constant.CacheConst;
import cn.enncloud.iot.iotmqtttransferkafkahps.dto.AnyLinkData;
import cn.enncloud.iot.iotmqtttransferkafkahps.dto.CommonData;
import cn.enncloud.iot.iotmqtttransferkafkahps.dto.SixNetData;
import cn.enncloud.iot.iotmqtttransferkafkahps.dto.TopicData;
import cn.enncloud.iot.iotmqtttransferkafkahps.repository.AnyLinkDataItemMappingDao;
import cn.enncloud.iot.iotmqtttransferkafkahps.service.IDataCacheService;
import cn.enncloud.iot.iotmqtttransferkafkahps.service.IQueryDataPoinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class DataCacheServiceImpl implements IDataCacheService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private AnyLinkDataItemMappingDao dataItemMappingDao;
    @Autowired
    private IQueryDataPoinService queryRedisCommonData;

    @Autowired
    private AdapterProperties adapterProperties;
    /**
     * 删除缓存
     *
     */
    public void deleteWithkeys() {
        try {
            String key = this.getKey();
            redisTemplate.delete(key);
        }catch (Exception e){
            log.error("删除点表缓存错误：{}",e);
        }

    }
    public long deleteWithAgentId(String hk) {
        try {
            String key = this.getKey();
            return redisTemplate.opsForHash().delete(key,hk);
        }catch (Exception e){
            log.error("删除点表缓存错误：{}",e);
            return 0;
        }

    }

    /**
     * 查询anylink采集点
     * @param agentId
     * @return
     */
    public List<AnyLinkData> getAnyLinkPointByAgentId(String agentId) {

        try {
            String key = getKey();
            List<AnyLinkData> dataList = (List<AnyLinkData>)redisTemplate.opsForHash().get(key,agentId);
            if(!CollectionUtils.isEmpty(dataList)){
                return dataList;
            }else {
                List<AnyLinkData> list = dataItemMappingDao.findByAgentId(agentId);
                if(!CollectionUtils.isEmpty(list)){
                    redisTemplate.opsForHash().put(key,agentId,list);
                    return list;
                }else {
                    return null;
                }

            }
        }catch (Exception e){
            log.error("查询anylink采集点异常:{}",e);
            return dataItemMappingDao.findByAgentId(agentId);
        }

    }

//    private String getKey(String agentId){
//        return adapterProperties.getPre()+"_"+CacheConst.IOT_CACHA_DATA+agentId;
//    }
    private String getKey(){
        return adapterProperties.getPre()+"_"+CacheConst.IOT_CACHA_DATA;
    }

    /**
     * 胜风合力网关采集点缓存
     * sixnet
     * @param agentId
     * @return
     */
    public  List<SixNetData> getByAgentId(String agentId) {
        try {
            String key = getKey();
            List<SixNetData> dataList = (List<SixNetData>)redisTemplate.opsForHash().get(key,agentId);
            if(!CollectionUtils.isEmpty(dataList)){
                return dataList;
            }else {
                List<SixNetData> list =  dataItemMappingDao.queryDeviceDataByAgentId(agentId);
                if(!CollectionUtils.isEmpty(list)){
                    redisTemplate.opsForHash().put(key,agentId,list);
                    return list;
                }else {
                    return null;
                }
            }
        }catch (Exception e){
            log.error("查询胜风合力网关采集点错误:{}",e);
            return dataItemMappingDao.queryDeviceDataByAgentId(agentId);
        }
    }


    /**
     * 业务域类型缓存
     *
     * @return
     */
    public Map<String, String> getCommonData() {
        try {
            String key = getKey();
            Map<String,String> dataList = (Map<String,String>)redisTemplate.opsForHash().entries(key).get(CacheConst.IOT_CACHA_COMMON_DATA);
            if(!CollectionUtils.isEmpty(dataList)){
                return dataList;
            }else {
                Map<String,String> data =  queryRedisCommonData.queryRedisCommonData();
                if(!CollectionUtils.isEmpty(data)){
                    redisTemplate.opsForHash().put(key,CacheConst.IOT_CACHA_COMMON_DATA,data);
                    return data;
                }else {
                    return null;
                }

            }
        }catch (Exception e){
            log.error("查询业务域错误:{}",e);
            return queryRedisCommonData.queryRedisCommonData();
        }
    }
    public List<CommonData> getCommonDataList() {
        try {
            String key =  getKey();
            List<CommonData> dataList = (List<CommonData>)redisTemplate.opsForHash().get(key,CacheConst.IOT_CACHA_COMMON_DATA);
            if(!CollectionUtils.isEmpty(dataList)){
                return dataList;
            }else {
                List<CommonData> data =  queryRedisCommonData.queryRedisCommonDataList();
                if(!CollectionUtils.isEmpty(data)){
                    redisTemplate.opsForHash().put(key,CacheConst.IOT_CACHA_COMMON_DATA,data);
                    return data;
                }else {
                    return null;
                }

            }
        }catch (Exception e){
            log.error("查询业务域错误:{}",e);
            return queryRedisCommonData.queryRedisCommonDataList();
        }
    }
    public  Object getByOrgId(Long orgid) {
        try {
            String key = getKey();
            Object res =redisTemplate.opsForHash().get(key,CacheConst.DATA_HUB_PRE+orgid);
            TopicData td;
            if(res ==null){
                //根据 orgid 查询站点id
                td =  dataItemMappingDao.getTopicDataByType(orgid);
                if(null == td){
                    log.error("获取业务域信息为空 orgId:{}",orgid);
                    return null;
                }
                //设置缓存后 应该再查询进行下面的操作
                redisTemplate.opsForHash().put(key,CacheConst.DATA_HUB_PRE+orgid,td);
                return  td;
            }else {
                return res;
            }
        }catch (Exception e){
            log.error("查询胜风合力网关采集点错误:{}",e);
            return null;
        }
    }



}
