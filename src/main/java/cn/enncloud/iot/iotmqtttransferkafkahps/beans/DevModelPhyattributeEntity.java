package cn.enncloud.iot.iotmqtttransferkafkahps.beans;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "dev_model_phyattribute")
public class DevModelPhyattributeEntity {
    private long id;
    private Timestamp createTime;
    private String createUser;
    private boolean deleted;
    private Timestamp updateTime;
    private String updateUser;
    private long version;
    private String attrGroup;
    private Integer byteLen;
    private String byteOrder;
    private Boolean controlFlag;
    private String depict;
    private Integer frequency;
    private Integer funCode;
    private Integer showIndex;
    private String maskCode;
    private String registerStie;
    private String shortName;
    private String targetPath;
    private String anylinkAddress;
    private Integer channel;
    private String cimPath;

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
    @Column(name = "attr_group", nullable = true, length = 100)
    public String getAttrGroup() {
        return attrGroup;
    }

    public void setAttrGroup(String attrGroup) {
        this.attrGroup = attrGroup;
    }

    @Basic
    @Column(name = "byte_len", nullable = true)
    public Integer getByteLen() {
        return byteLen;
    }

    public void setByteLen(Integer byteLen) {
        this.byteLen = byteLen;
    }

    @Basic
    @Column(name = "byte_order", nullable = true, length = 255)
    public String getByteOrder() {
        return byteOrder;
    }

    public void setByteOrder(String byteOrder) {
        this.byteOrder = byteOrder;
    }

    @Basic
    @Column(name = "control_flag", nullable = true)
    public Boolean getControlFlag() {
        return controlFlag;
    }

    public void setControlFlag(Boolean controlFlag) {
        this.controlFlag = controlFlag;
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
    @Column(name = "frequency", nullable = true)
    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    @Basic
    @Column(name = "fun_code", nullable = true)
    public Integer getFunCode() {
        return funCode;
    }

    public void setFunCode(Integer funCode) {
        this.funCode = funCode;
    }

    @Basic
    @Column(name = "show_index", nullable = true)
    public Integer getShowIndex() {
        return showIndex;
    }

    public void setShowIndex(Integer showIndex) {
        this.showIndex = showIndex;
    }

    @Basic
    @Column(name = "mask_code", nullable = true, length = 255)
    public String getMaskCode() {
        return maskCode;
    }

    public void setMaskCode(String maskCode) {
        this.maskCode = maskCode;
    }

    @Basic
    @Column(name = "register_stie", nullable = true, length = 200)
    public String getRegisterStie() {
        return registerStie;
    }

    public void setRegisterStie(String registerStie) {
        this.registerStie = registerStie;
    }

    @Basic
    @Column(name = "short_name", nullable = true, length = 10)
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Basic
    @Column(name = "target_path", nullable = false, length = 100)
    public String getTargetPath() {
        return targetPath;
    }

    public void setTargetPath(String targetPath) {
        this.targetPath = targetPath;
    }

    @Basic
    @Column(name = "anylink_address", nullable = true, length = 10)
    public String getAnylinkAddress() {
        return anylinkAddress;
    }

    public void setAnylinkAddress(String anylinkAddress) {
        this.anylinkAddress = anylinkAddress;
    }

    @Basic
    @Column(name = "channel", nullable = true)
    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

//    @Basic
//    @Column(name = "cim_path", nullable = true, length = 100)
    @Transient
    public String getCimPath() {
        return cimPath;
    }

    public void setCimPath(String cimPath) {
        this.cimPath = cimPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DevModelPhyattributeEntity that = (DevModelPhyattributeEntity) o;
        return id == that.id &&
                deleted == that.deleted &&
                version == that.version &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(createUser, that.createUser) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(updateUser, that.updateUser) &&
                Objects.equals(attrGroup, that.attrGroup) &&
                Objects.equals(byteLen, that.byteLen) &&
                Objects.equals(byteOrder, that.byteOrder) &&
                Objects.equals(controlFlag, that.controlFlag) &&
                Objects.equals(depict, that.depict) &&
                Objects.equals(frequency, that.frequency) &&
                Objects.equals(funCode, that.funCode) &&
                Objects.equals(showIndex, that.showIndex) &&
                Objects.equals(maskCode, that.maskCode) &&
                Objects.equals(registerStie, that.registerStie) &&
                Objects.equals(shortName, that.shortName) &&
                Objects.equals(targetPath, that.targetPath) &&
                Objects.equals(anylinkAddress, that.anylinkAddress) &&
                Objects.equals(channel, that.channel) &&
                Objects.equals(cimPath, that.cimPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime, createUser, deleted, updateTime, updateUser, version, attrGroup, byteLen, byteOrder, controlFlag, depict, frequency, funCode, showIndex, maskCode, registerStie, shortName, targetPath, anylinkAddress, channel, cimPath);
    }
}
