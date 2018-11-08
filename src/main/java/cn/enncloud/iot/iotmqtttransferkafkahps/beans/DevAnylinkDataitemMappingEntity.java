package cn.enncloud.iot.iotmqtttransferkafkahps.beans;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "dev_anylink_dataitem_mapping", schema = "hps_test", catalog = "")
public class DevAnylinkDataitemMappingEntity {
    private long id;
    private Timestamp createTime;
    private String createUser;
    private boolean deleted;
    private Timestamp updateTime;
    private String updateUser;
    private long version;
    private long agentId;
    private long devId;
    private int did;
    private int itemId;
    private String itemName;

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
    @Column(name = "agent_id", nullable = false)
    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(long agentId) {
        this.agentId = agentId;
    }

    @Basic
    @Column(name = "dev_id", nullable = false)
    public long getDevId() {
        return devId;
    }

    public void setDevId(long devId) {
        this.devId = devId;
    }

    @Basic
    @Column(name = "did", nullable = false)
    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    @Basic
    @Column(name = "item_id", nullable = false)
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "item_name", nullable = false, length = 255)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DevAnylinkDataitemMappingEntity that = (DevAnylinkDataitemMappingEntity) o;
        return id == that.id &&
                deleted == that.deleted &&
                version == that.version &&
                agentId == that.agentId &&
                devId == that.devId &&
                did == that.did &&
                itemId == that.itemId &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(createUser, that.createUser) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(updateUser, that.updateUser) &&
                Objects.equals(itemName, that.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime, createUser, deleted, updateTime, updateUser, version, agentId, devId, did, itemId, itemName);
    }
}
