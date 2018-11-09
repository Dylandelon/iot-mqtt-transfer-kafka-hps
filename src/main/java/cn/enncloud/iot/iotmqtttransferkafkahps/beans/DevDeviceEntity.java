package cn.enncloud.iot.iotmqtttransferkafkahps.beans;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "dev_device")
public class DevDeviceEntity {
    private long id;
    private Timestamp createTime;
    private String createUser;
    private boolean deleted;
    private Timestamp updateTime;
    private String updateUser;
    private long version;
    private String address;
    private Boolean alarmActive;
    private String addrCity;
    private String depict;
    private Integer deviceType;
    private Integer enginePower;
    private String equipNum;
    private String ipAddress;
    private BigDecimal addrLatitude;
    private BigDecimal addrLongitude;
    private String port;
    private String addrProvince;
    private String serialnumber;
    private Integer slaveStation;
    private String alarmSource;
    private String state;
    private String devSupplier;
    private String engineManufactor;
    private String dtuCode;
    private Integer collectionFrequency;
    private String collectionMode;
    private String reportTime;
    private String comPort;
    private String orgErpCode;
    private Double flowRangeHigh;
    private Double flowRangeLow;
    private Double tankTotal;
    private String deviceTypeName;
    private String branche;
    private String accessWay;
    private String parseMode;
    private String parseType;
    private String addrRegion;
    private String gatewayDevNum;
    private String remarks;
    private Long source;
    private String devCimId;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "create_user", nullable = true, length = 50)
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Basic
    @Column(name = "deleted", nullable = false)
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Basic
    @Column(name = "update_time", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "update_user", nullable = true, length = 50)
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Basic
    @Column(name = "version", nullable = false)
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "alarm_active", nullable = true)
    public Boolean getAlarmActive() {
        return alarmActive;
    }

    public void setAlarmActive(Boolean alarmActive) {
        this.alarmActive = alarmActive;
    }

    @Basic
    @Column(name = "addr_city", nullable = true, length = 20)
    public String getAddrCity() {
        return addrCity;
    }

    public void setAddrCity(String addrCity) {
        this.addrCity = addrCity;
    }

    @Basic
    @Column(name = "depict", nullable = false, length = 100)
    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict;
    }

    @Basic
    @Column(name = "device_type", nullable = true)
    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    @Basic
    @Column(name = "engine_power", nullable = true)
    public Integer getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    @Basic
    @Column(name = "equip_num", nullable = true, length = 255)
    public String getEquipNum() {
        return equipNum;
    }

    public void setEquipNum(String equipNum) {
        this.equipNum = equipNum;
    }

    @Basic
    @Column(name = "ip_address", nullable = true, length = 200)
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Basic
    @Column(name = "addr_latitude", nullable = true, precision = 4)
    public BigDecimal getAddrLatitude() {
        return addrLatitude;
    }

    public void setAddrLatitude(BigDecimal addrLatitude) {
        this.addrLatitude = addrLatitude;
    }

    @Basic
    @Column(name = "addr_longitude", nullable = true, precision = 4)
    public BigDecimal getAddrLongitude() {
        return addrLongitude;
    }

    public void setAddrLongitude(BigDecimal addrLongitude) {
        this.addrLongitude = addrLongitude;
    }

    @Basic
    @Column(name = "port", nullable = true, length = 20)
    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Basic
    @Column(name = "addr_province", nullable = true, length = 20)
    public String getAddrProvince() {
        return addrProvince;
    }

    public void setAddrProvince(String addrProvince) {
        this.addrProvince = addrProvince;
    }

    @Basic
    @Column(name = "serialnumber", nullable = false, length = 50)
    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    @Basic
    @Column(name = "slave_station", nullable = true)
    public Integer getSlaveStation() {
        return slaveStation;
    }

    public void setSlaveStation(Integer slaveStation) {
        this.slaveStation = slaveStation;
    }

    @Basic
    @Column(name = "alarm_source", nullable = true, length = 20)
    public String getAlarmSource() {
        return alarmSource;
    }

    public void setAlarmSource(String alarmSource) {
        this.alarmSource = alarmSource;
    }

    @Basic
    @Column(name = "state", nullable = false, length = 20)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "dev_supplier", nullable = true, length = 255)
    public String getDevSupplier() {
        return devSupplier;
    }

    public void setDevSupplier(String devSupplier) {
        this.devSupplier = devSupplier;
    }

    @Basic
    @Column(name = "engine_manufactor", nullable = true, length = 255)
    public String getEngineManufactor() {
        return engineManufactor;
    }

    public void setEngineManufactor(String engineManufactor) {
        this.engineManufactor = engineManufactor;
    }

    @Basic
    @Column(name = "dtu_code", nullable = true, length = 50)
    public String getDtuCode() {
        return dtuCode;
    }

    public void setDtuCode(String dtuCode) {
        this.dtuCode = dtuCode;
    }

    @Basic
    @Column(name = "collection_frequency", nullable = true)
    public Integer getCollectionFrequency() {
        return collectionFrequency;
    }

    public void setCollectionFrequency(Integer collectionFrequency) {
        this.collectionFrequency = collectionFrequency;
    }

    @Basic
    @Column(name = "collection_mode", nullable = true, length = 20)
    public String getCollectionMode() {
        return collectionMode;
    }

    public void setCollectionMode(String collectionMode) {
        this.collectionMode = collectionMode;
    }

    @Basic
    @Column(name = "report_time", nullable = true, length = 255)
    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    @Basic
    @Column(name = "com_port", nullable = true, length = 20)
    public String getComPort() {
        return comPort;
    }

    public void setComPort(String comPort) {
        this.comPort = comPort;
    }

    @Basic
    @Column(name = "org_erp_code", nullable = true, length = 255)
    public String getOrgErpCode() {
        return orgErpCode;
    }

    public void setOrgErpCode(String orgErpCode) {
        this.orgErpCode = orgErpCode;
    }

    @Basic
    @Column(name = "flow_range_high", nullable = true, precision = 0)
    public Double getFlowRangeHigh() {
        return flowRangeHigh;
    }

    public void setFlowRangeHigh(Double flowRangeHigh) {
        this.flowRangeHigh = flowRangeHigh;
    }

    @Basic
    @Column(name = "flow_range_low", nullable = true, precision = 0)
    public Double getFlowRangeLow() {
        return flowRangeLow;
    }

    public void setFlowRangeLow(Double flowRangeLow) {
        this.flowRangeLow = flowRangeLow;
    }

    @Basic
    @Column(name = "tank_total", nullable = true, precision = 0)
    public Double getTankTotal() {
        return tankTotal;
    }

    public void setTankTotal(Double tankTotal) {
        this.tankTotal = tankTotal;
    }

    @Basic
    @Column(name = "device_type_name", nullable = true, length = 255)
    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    @Basic
    @Column(name = "branche", nullable = true, length = 100)
    public String getBranche() {
        return branche;
    }

    public void setBranche(String branche) {
        this.branche = branche;
    }

    @Basic
    @Column(name = "access_way", nullable = true, length = 20)
    public String getAccessWay() {
        return accessWay;
    }

    public void setAccessWay(String accessWay) {
        this.accessWay = accessWay;
    }

    @Basic
    @Column(name = "parse_mode", nullable = true, length = 50)
    public String getParseMode() {
        return parseMode;
    }

    public void setParseMode(String parseMode) {
        this.parseMode = parseMode;
    }

    @Basic
    @Column(name = "parse_type", nullable = true, length = 20)
    public String getParseType() {
        return parseType;
    }

    public void setParseType(String parseType) {
        this.parseType = parseType;
    }

    @Basic
    @Column(name = "addr_region", nullable = true, length = 50)
    public String getAddrRegion() {
        return addrRegion;
    }

    public void setAddrRegion(String addrRegion) {
        this.addrRegion = addrRegion;
    }

    @Basic
    @Column(name = "gateway_dev_num", nullable = true, length = 50)
    public String getGatewayDevNum() {
        return gatewayDevNum;
    }

    public void setGatewayDevNum(String gatewayDevNum) {
        this.gatewayDevNum = gatewayDevNum;
    }

    @Basic
    @Column(name = "remarks", nullable = true, length = 30)
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Basic
    @Column(name = "source", nullable = true)
    public Long getSource() {
        return source;
    }

    public void setSource(Long source) {
        this.source = source;
    }

//    @Basic
//    @Column(name = "dev_cim_id", nullable = true, length = 50)
    @Transient
    public String getDevCimId() {
        return devCimId;
    }

    public void setDevCimId(String devCimId) {
        this.devCimId = devCimId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DevDeviceEntity that = (DevDeviceEntity) o;
        return id == that.id &&
                deleted == that.deleted &&
                version == that.version &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(createUser, that.createUser) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(updateUser, that.updateUser) &&
                Objects.equals(address, that.address) &&
                Objects.equals(alarmActive, that.alarmActive) &&
                Objects.equals(addrCity, that.addrCity) &&
                Objects.equals(depict, that.depict) &&
                Objects.equals(deviceType, that.deviceType) &&
                Objects.equals(enginePower, that.enginePower) &&
                Objects.equals(equipNum, that.equipNum) &&
                Objects.equals(ipAddress, that.ipAddress) &&
                Objects.equals(addrLatitude, that.addrLatitude) &&
                Objects.equals(addrLongitude, that.addrLongitude) &&
                Objects.equals(port, that.port) &&
                Objects.equals(addrProvince, that.addrProvince) &&
                Objects.equals(serialnumber, that.serialnumber) &&
                Objects.equals(slaveStation, that.slaveStation) &&
                Objects.equals(alarmSource, that.alarmSource) &&
                Objects.equals(state, that.state) &&
                Objects.equals(devSupplier, that.devSupplier) &&
                Objects.equals(engineManufactor, that.engineManufactor) &&
                Objects.equals(dtuCode, that.dtuCode) &&
                Objects.equals(collectionFrequency, that.collectionFrequency) &&
                Objects.equals(collectionMode, that.collectionMode) &&
                Objects.equals(reportTime, that.reportTime) &&
                Objects.equals(comPort, that.comPort) &&
                Objects.equals(orgErpCode, that.orgErpCode) &&
                Objects.equals(flowRangeHigh, that.flowRangeHigh) &&
                Objects.equals(flowRangeLow, that.flowRangeLow) &&
                Objects.equals(tankTotal, that.tankTotal) &&
                Objects.equals(deviceTypeName, that.deviceTypeName) &&
                Objects.equals(branche, that.branche) &&
                Objects.equals(accessWay, that.accessWay) &&
                Objects.equals(parseMode, that.parseMode) &&
                Objects.equals(parseType, that.parseType) &&
                Objects.equals(addrRegion, that.addrRegion) &&
                Objects.equals(gatewayDevNum, that.gatewayDevNum) &&
                Objects.equals(remarks, that.remarks) &&
                Objects.equals(source, that.source) &&
                Objects.equals(devCimId, that.devCimId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime, createUser, deleted, updateTime, updateUser, version, address, alarmActive, addrCity, depict, deviceType, enginePower, equipNum, ipAddress, addrLatitude, addrLongitude, port, addrProvince, serialnumber, slaveStation, alarmSource, state, devSupplier, engineManufactor, dtuCode, collectionFrequency, collectionMode, reportTime, comPort, orgErpCode, flowRangeHigh, flowRangeLow, tankTotal, deviceTypeName, branche, accessWay, parseMode, parseType, addrRegion, gatewayDevNum, remarks, source, devCimId);
    }
}
