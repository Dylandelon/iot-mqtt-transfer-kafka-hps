package cn.enncloud.iot.iotmqtttransferkafkahps.repository.impl;


import cn.enncloud.iot.iotmqtttransferkafkahps.dto.AnyLinkData;
import cn.enncloud.iot.iotmqtttransferkafkahps.dto.CommonData;
import cn.enncloud.iot.iotmqtttransferkafkahps.dto.SixNetData;
import cn.enncloud.iot.iotmqtttransferkafkahps.dto.TopicData;
import cn.enncloud.iot.iotmqtttransferkafkahps.repository.AnyLinkDataItemMappingDao;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by zhangdelong on 2017/8/22.
 */
@Repository
public class AnyLinkDataItemMappingDaoImpl implements AnyLinkDataItemMappingDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	@Override
	public List<AnyLinkData> findByAgentId (String agentId ) {
		String sql = "SELECT dev.gateway_dev_num did, mapping.item_id itemId, mapping.device_id deviceId,  phy.target_path metric,phy.attr_group attrGroup, dev.device_type devType,dev.depict deviceName,dev.org_id orgId,phy.mask_code maskCode,dev.serialnumber,dev.dev_cim_id devCimId,phy.cim_path cimPath  " +
				" FROM  dev_anylink_dataitem_mapping mapping " +
				" LEFT JOIN dev_model_phyattribute phy ON phy.id = mapping.model_phy_attribute_id" +
				" LEFT JOIN dev_device dev ON dev.id = mapping.device_id" +
				" WHERE dev.deleted = 0 and  mapping.agent_id = :agentId";

		SQLQuery nativeQuery = em.createNativeQuery(sql).unwrap(SQLQuery.class);
		nativeQuery.setParameter("agentId",Long.parseLong(agentId))
				.setResultTransformer(Transformers.aliasToBean(AnyLinkData.class));
		return nativeQuery.list();
	}

	@Transactional(readOnly = true)
	@Override
	public TopicData getTopicDataByType(Long orgId) {
		String sql = " select    c.data_value dataValue ,c.data_name_short dataNameShort,c.data_topic dataTopic,o.stand_id standId ,o.cim_stand_id cimStandId  " +
				"from common_data c,org_info o " +
				"where o.id=:orgId  and c.data_type=2 and c.deleted=0  and  o.device_type = c.data_value   ";
		SQLQuery nativeQuery = em.createNativeQuery(sql).unwrap(SQLQuery.class);
		nativeQuery.setParameter("orgId",orgId)
				.setResultTransformer(Transformers.aliasToBean(TopicData.class));

		List<TopicData> list =  nativeQuery.list();
		if(list!= null && list.size()>0){
			return list.get(0);
		}else {
      return null;
    }
	}


	@Transactional(readOnly = true)
	@Override
	public List<SixNetData> queryDeviceDataByAgentId(String agentId){
		String sql = "SELECT dev.id did, phy.id itemId, dev.id deviceId,  phy.target_path metric,phy.attr_group attrGroup, dev.device_type devType,dev.depict deviceName,dev.org_id orgId,dev.serialnumber,dev.dev_cim_id devCimId,phy.cim_path cimPath " +
				" FROM  dev_device dev " +
				"   JOIN dev_model_phyattribute phy ON phy.model_id = dev.model_id" +
				"   JOIN  dev_gateway gateway ON dev.gateway_id = gateway.id" +
				" WHERE gateway.serialnumber = :agentId";

		SQLQuery nativeQuery = em.createNativeQuery(sql).unwrap(SQLQuery.class);
		nativeQuery.setParameter("agentId",agentId)
				.setResultTransformer(Transformers.aliasToBean(SixNetData.class));

		List<SixNetData> list = nativeQuery.list();


		return list;
	}


	@Transactional(readOnly = true)
	@Override
	public List<CommonData> queryCommonData(String dateType){
		String sql = "SELECT data_name dataName  ,data_value dataValue, data_name_short dataNameShort,cim_data_name cimDataName  from common_data where data_type=:dateType " ;


		SQLQuery nativeQuery = em.createNativeQuery(sql).unwrap(SQLQuery.class);
		nativeQuery.setParameter("dateType",dateType)
				.setResultTransformer(Transformers.aliasToBean(CommonData.class));

		return  nativeQuery.list();
	}



}
