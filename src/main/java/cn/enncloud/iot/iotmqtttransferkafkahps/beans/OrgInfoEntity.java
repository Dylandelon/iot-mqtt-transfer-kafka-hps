package cn.enncloud.iot.iotmqtttransferkafkahps.beans;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "org_info")
public class OrgInfoEntity {
    private long id;
    private Timestamp createTime;
    private String createUser;
    private boolean deleted;
    private Timestamp updateTime;
    private String updateUser;
    private long version;
    private String depict;
    private Integer orgType;
    private String path;
    private String projectId;
    private Integer sort;
    private boolean status;
    private String authorizationCode;
    private String compCode;
    private Integer deviceType;
    private String entityCode;
    private String erpCode;
    private String orgLevel;
    private int orgRange;
    private String parentCode;
    private String swerk;
    private String tabZj;
    private String tabZn;
    private Timestamp orgCreateTime;
    private String standId;
    private String deviceTypeName;
    private String cimStandId;

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
    @Column(name = "org_type", nullable = true)
    public Integer getOrgType() {
        return orgType;
    }

    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
    }

    @Basic
    @Column(name = "path", nullable = true, length = 255)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "project_id", nullable = true, length = 255)
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "sort", nullable = true)
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
    @Column(name = "authorization_code", nullable = true, length = 30)
    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    @Basic
    @Column(name = "comp_code", nullable = true, length = 50)
    public String getCompCode() {
        return compCode;
    }

    public void setCompCode(String compCode) {
        this.compCode = compCode;
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
    @Column(name = "entity_code", nullable = true, length = 50)
    public String getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

    @Basic
    @Column(name = "erp_code", nullable = false, length = 50)
    public String getErpCode() {
        return erpCode;
    }

    public void setErpCode(String erpCode) {
        this.erpCode = erpCode;
    }

    @Basic
    @Column(name = "org_level", nullable = false, length = 2)
    public String getOrgLevel() {
        return orgLevel;
    }

    public void setOrgLevel(String orgLevel) {
        this.orgLevel = orgLevel;
    }

    @Basic
    @Column(name = "org_range", nullable = false)
    public int getOrgRange() {
        return orgRange;
    }

    public void setOrgRange(int orgRange) {
        this.orgRange = orgRange;
    }

    @Basic
    @Column(name = "parent_code", nullable = true, length = 50)
    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    @Basic
    @Column(name = "swerk", nullable = true, length = 2)
    public String getSwerk() {
        return swerk;
    }

    public void setSwerk(String swerk) {
        this.swerk = swerk;
    }

    @Basic
    @Column(name = "tab_zj", nullable = true, length = 2)
    public String getTabZj() {
        return tabZj;
    }

    public void setTabZj(String tabZj) {
        this.tabZj = tabZj;
    }

    @Basic
    @Column(name = "tab_zn", nullable = true, length = 2)
    public String getTabZn() {
        return tabZn;
    }

    public void setTabZn(String tabZn) {
        this.tabZn = tabZn;
    }

    @Basic
    @Column(name = "org_create_time", nullable = true)
    public Timestamp getOrgCreateTime() {
        return orgCreateTime;
    }

    public void setOrgCreateTime(Timestamp orgCreateTime) {
        this.orgCreateTime = orgCreateTime;
    }

    @Basic
    @Column(name = "stand_id", nullable = true, length = 255)
    public String getStandId() {
        return standId;
    }

    public void setStandId(String standId) {
        this.standId = standId;
    }

    @Basic
    @Column(name = "device_type_name", nullable = true, length = 100)
    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    @Basic
    @Column(name = "cim_stand_id", nullable = true, length = 255)
    public String getCimStandId() {
        return cimStandId;
    }

    public void setCimStandId(String cimStandId) {
        this.cimStandId = cimStandId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrgInfoEntity that = (OrgInfoEntity) o;
        return id == that.id &&
                deleted == that.deleted &&
                version == that.version &&
                status == that.status &&
                orgRange == that.orgRange &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(createUser, that.createUser) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(updateUser, that.updateUser) &&
                Objects.equals(depict, that.depict) &&
                Objects.equals(orgType, that.orgType) &&
                Objects.equals(path, that.path) &&
                Objects.equals(projectId, that.projectId) &&
                Objects.equals(sort, that.sort) &&
                Objects.equals(authorizationCode, that.authorizationCode) &&
                Objects.equals(compCode, that.compCode) &&
                Objects.equals(deviceType, that.deviceType) &&
                Objects.equals(entityCode, that.entityCode) &&
                Objects.equals(erpCode, that.erpCode) &&
                Objects.equals(orgLevel, that.orgLevel) &&
                Objects.equals(parentCode, that.parentCode) &&
                Objects.equals(swerk, that.swerk) &&
                Objects.equals(tabZj, that.tabZj) &&
                Objects.equals(tabZn, that.tabZn) &&
                Objects.equals(orgCreateTime, that.orgCreateTime) &&
                Objects.equals(standId, that.standId) &&
                Objects.equals(cimStandId, that.cimStandId) &&
                Objects.equals(deviceTypeName, that.deviceTypeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime, createUser, deleted, updateTime, updateUser, version, depict, orgType, path, projectId, sort, status, authorizationCode, compCode, deviceType, entityCode, erpCode, orgLevel, orgRange, parentCode, swerk, tabZj, tabZn, orgCreateTime, standId, deviceTypeName,cimStandId);
    }
}
