package cn.enncloud.iot.iotmqtttransferkafkahps.beans;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "common_data", schema = "hps_test", catalog = "")
public class CommonDataEntity {
    private long id;
    private String dataName;
    private String dataValue;
    private String dataType;
    private String dataNameShort;
    private String dataTopic;
    private Timestamp createTime;
    private String createUser;
    private boolean deleted;
    private Timestamp updateTime;
    private String updateUser;
    private long version;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "data_name", nullable = true, length = 100)
    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    @Basic
    @Column(name = "data_value", nullable = true, length = 5)
    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    @Basic
    @Column(name = "data_type", nullable = true, length = 1)
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Basic
    @Column(name = "data_name_short", nullable = true, length = 30)
    public String getDataNameShort() {
        return dataNameShort;
    }

    public void setDataNameShort(String dataNameShort) {
        this.dataNameShort = dataNameShort;
    }

    @Basic
    @Column(name = "data_topic", nullable = true, length = 100)
    public String getDataTopic() {
        return dataTopic;
    }

    public void setDataTopic(String dataTopic) {
        this.dataTopic = dataTopic;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonDataEntity that = (CommonDataEntity) o;
        return id == that.id &&
                deleted == that.deleted &&
                version == that.version &&
                Objects.equals(dataName, that.dataName) &&
                Objects.equals(dataValue, that.dataValue) &&
                Objects.equals(dataType, that.dataType) &&
                Objects.equals(dataNameShort, that.dataNameShort) &&
                Objects.equals(dataTopic, that.dataTopic) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(createUser, that.createUser) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(updateUser, that.updateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataName, dataValue, dataType, dataNameShort, dataTopic, createTime, createUser, deleted, updateTime, updateUser, version);
    }
}
