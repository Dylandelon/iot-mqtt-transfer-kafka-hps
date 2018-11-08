package cn.enncloud.iot.iotmqtttransferkafkahps.beans;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "dev_gateway")
public class DevGatewayEntity {
    private long id;
    private Timestamp createTime;
    private String createUser;
    private boolean deleted;
    private Timestamp updateTime;
    private String updateUser;
    private long version;
    private String depict;
    private String firm;
    private String model;
    private Long registerId;
    private Boolean registerStatus;
    private String serialnumber;
    private boolean status;
    private String configStatus;
    private String orgErpCode;
    private String addr;
    private String city;
    private String latitude;
    private String longitude;
    private String type;
    private String address;
    private String iccid;

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
    @Column(name = "depict", nullable = false, length = 100)
    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict;
    }

    @Basic
    @Column(name = "firm", nullable = true, length = 100)
    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    @Basic
    @Column(name = "model", nullable = true, length = 100)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "register_id", nullable = true)
    public Long getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Long registerId) {
        this.registerId = registerId;
    }

    @Basic
    @Column(name = "register_status", nullable = true)
    public Boolean getRegisterStatus() {
        return registerStatus;
    }

    public void setRegisterStatus(Boolean registerStatus) {
        this.registerStatus = registerStatus;
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
    @Column(name = "status", nullable = false)
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Basic
    @Column(name = "config_status", nullable = true, length = 255)
    public String getConfigStatus() {
        return configStatus;
    }

    public void setConfigStatus(String configStatus) {
        this.configStatus = configStatus;
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
    @Column(name = "addr", nullable = true, length = 255)
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 255)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "latitude", nullable = true, length = 255)
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude", nullable = true, length = 255)
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 50)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    @Column(name = "iccid", nullable = true, length = 100)
    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DevGatewayEntity that = (DevGatewayEntity) o;
        return id == that.id &&
                deleted == that.deleted &&
                version == that.version &&
                status == that.status &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(createUser, that.createUser) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(updateUser, that.updateUser) &&
                Objects.equals(depict, that.depict) &&
                Objects.equals(firm, that.firm) &&
                Objects.equals(model, that.model) &&
                Objects.equals(registerId, that.registerId) &&
                Objects.equals(registerStatus, that.registerStatus) &&
                Objects.equals(serialnumber, that.serialnumber) &&
                Objects.equals(configStatus, that.configStatus) &&
                Objects.equals(orgErpCode, that.orgErpCode) &&
                Objects.equals(addr, that.addr) &&
                Objects.equals(city, that.city) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(type, that.type) &&
                Objects.equals(address, that.address) &&
                Objects.equals(iccid, that.iccid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime, createUser, deleted, updateTime, updateUser, version, depict, firm, model, registerId, registerStatus, serialnumber, status, configStatus, orgErpCode, addr, city, latitude, longitude, type, address, iccid);
    }
}
