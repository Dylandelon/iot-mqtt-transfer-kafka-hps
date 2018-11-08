package cn.enncloud.iot.iotmqtttransferkafkahps.beans;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "dev_point_table_config", schema = "hps_test", catalog = "")
public class DevPointTableConfigEntity {
    private long id;
    private Timestamp createTime;
    private String createUser;
    private boolean deleted;
    private Timestamp updateTime;
    private String updateUser;
    private long version;
    private String aliasName;
    private String alignment;
    private String byGroup;
    private String byStation;
    private String cimName;
    private Long collectionFrequency;
    private String controlBit;
    private String dataType;
    private String devCode;
    private String devName;
    private String functionCode;
    private String indexFullPath;
    private String indexName;
    private String measureUnit;
    private String modbusAddress;
    private String register;
    private Long devType;
    private String rateLinear;
    private Integer channel;

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
    @Column(name = "alias_name", nullable = true, length = 30)
    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    @Basic
    @Column(name = "alignment", nullable = true, length = 30)
    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    @Basic
    @Column(name = "by_group", nullable = true, length = 30)
    public String getByGroup() {
        return byGroup;
    }

    public void setByGroup(String byGroup) {
        this.byGroup = byGroup;
    }

    @Basic
    @Column(name = "by_station", nullable = true, length = 30)
    public String getByStation() {
        return byStation;
    }

    public void setByStation(String byStation) {
        this.byStation = byStation;
    }

    @Basic
    @Column(name = "cim_name", nullable = true, length = 30)
    public String getCimName() {
        return cimName;
    }

    public void setCimName(String cimName) {
        this.cimName = cimName;
    }

    @Basic
    @Column(name = "collection_frequency", nullable = true)
    public Long getCollectionFrequency() {
        return collectionFrequency;
    }

    public void setCollectionFrequency(Long collectionFrequency) {
        this.collectionFrequency = collectionFrequency;
    }

    @Basic
    @Column(name = "control_bit", nullable = true, length = 30)
    public String getControlBit() {
        return controlBit;
    }

    public void setControlBit(String controlBit) {
        this.controlBit = controlBit;
    }

    @Basic
    @Column(name = "data_type", nullable = true, length = 30)
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Basic
    @Column(name = "dev_code", nullable = true, length = 30)
    public String getDevCode() {
        return devCode;
    }

    public void setDevCode(String devCode) {
        this.devCode = devCode;
    }

    @Basic
    @Column(name = "dev_name", nullable = true, length = 30)
    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    @Basic
    @Column(name = "function_code", nullable = true, length = 30)
    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    @Basic
    @Column(name = "index_full_path", nullable = true, length = 30)
    public String getIndexFullPath() {
        return indexFullPath;
    }

    public void setIndexFullPath(String indexFullPath) {
        this.indexFullPath = indexFullPath;
    }

    @Basic
    @Column(name = "index_name", nullable = true, length = 30)
    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    @Basic
    @Column(name = "measure_unit", nullable = true, length = 30)
    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    @Basic
    @Column(name = "modbus_address", nullable = true, length = 30)
    public String getModbusAddress() {
        return modbusAddress;
    }

    public void setModbusAddress(String modbusAddress) {
        this.modbusAddress = modbusAddress;
    }

    @Basic
    @Column(name = "register", nullable = true, length = 30)
    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    @Basic
    @Column(name = "dev_type", nullable = true)
    public Long getDevType() {
        return devType;
    }

    public void setDevType(Long devType) {
        this.devType = devType;
    }

    @Basic
    @Column(name = "rate_linear", nullable = true, length = 30)
    public String getRateLinear() {
        return rateLinear;
    }

    public void setRateLinear(String rateLinear) {
        this.rateLinear = rateLinear;
    }

    @Basic
    @Column(name = "channel", nullable = true)
    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DevPointTableConfigEntity that = (DevPointTableConfigEntity) o;
        return id == that.id &&
                deleted == that.deleted &&
                version == that.version &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(createUser, that.createUser) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(updateUser, that.updateUser) &&
                Objects.equals(aliasName, that.aliasName) &&
                Objects.equals(alignment, that.alignment) &&
                Objects.equals(byGroup, that.byGroup) &&
                Objects.equals(byStation, that.byStation) &&
                Objects.equals(cimName, that.cimName) &&
                Objects.equals(collectionFrequency, that.collectionFrequency) &&
                Objects.equals(controlBit, that.controlBit) &&
                Objects.equals(dataType, that.dataType) &&
                Objects.equals(devCode, that.devCode) &&
                Objects.equals(devName, that.devName) &&
                Objects.equals(functionCode, that.functionCode) &&
                Objects.equals(indexFullPath, that.indexFullPath) &&
                Objects.equals(indexName, that.indexName) &&
                Objects.equals(measureUnit, that.measureUnit) &&
                Objects.equals(modbusAddress, that.modbusAddress) &&
                Objects.equals(register, that.register) &&
                Objects.equals(devType, that.devType) &&
                Objects.equals(rateLinear, that.rateLinear) &&
                Objects.equals(channel, that.channel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime, createUser, deleted, updateTime, updateUser, version, aliasName, alignment, byGroup, byStation, cimName, collectionFrequency, controlBit, dataType, devCode, devName, functionCode, indexFullPath, indexName, measureUnit, modbusAddress, register, devType, rateLinear, channel);
    }
}
