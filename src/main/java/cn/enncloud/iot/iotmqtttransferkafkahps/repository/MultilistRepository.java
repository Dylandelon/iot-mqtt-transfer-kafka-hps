package cn.enncloud.iot.iotmqtttransferkafkahps.repository;

//public interface MultilistRepository  extends JpaRepository<DevDeviceEntity,Long> {
public interface MultilistRepository {
//    @Query(value = "SELECT  new cn.enncloud.iot.iotmqtttransferkafkahps.dto.SixNetData(dev.id as deviceId,phy.targetPath as metric,dev.id as did, phy.id as itemId," +
//            " dev.deviceType as devType,dev.depict as deviceName,dev.orgId as orgId, phy.attrGroup as attrGroup,dev.devCimId as devCimId,phy.cimPath as cimPath  )" +
//            " FROM  DevDeviceEntity dev " +
//            "   JOIN DevModelPhyattributeEntity phy ON phy.modelId = dev.modelId " +
//            "   JOIN  DevGatewayEntity gateway ON dev.gatewayId = gateway.id  " +
//            " WHERE gateway.serialnumber = :agentId ")
//    List<SixNetData> queryDeviceDataByAgentId(@Param(value = "agentId") String agentId);
}
