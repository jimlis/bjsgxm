package com.ifast.oss.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <pre>
 * 文件上传
 * </pre>
 * <small> 2018年3月23日 | Aron</small>
 */
@TableName("sys_file")
public class FileDO extends Model<FileDO> implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    
    //
    @TableId
    private Long id;
    /**
     * 业务表名
     */
    private  String busType;
    /**
     * 业务id
     */
    private  Long busId;
    /**
     * 文件类型
     */
    private Integer type;
    /**
     * 文件名称
     */
    @TableField()
    private  String fileName;
    /**
     * 文件大小
     */
    private  Long fileSize;
    /**
     * 创建人id
     */
    private  Long createUserId;
    /**
     * 创建人名称
     */
    private  String createUserName;
    /**
     * 创建人部门id
     */
    private  Long createDeptId;
    /***
     * 创建人部门名称
     */
    private  String createDeptName;
    /**
     * URL地址
     */
    private String url;

    // 创建时间
    private Date createDate;

    public FileDO() {

    }

    public FileDO(int type, String url, Date date) {
        this.type=type;
        this.url=url;
        this.createDate=date;
    }


    /**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：文件类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取：文件类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置：URL地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取：URL地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 获取：业务表名
     */
    public String getBusType() {
        return busType;
    }

    /**
     * 设置：业务表名
     */
    public void setBusType(String busType) {
        this.busType = busType;
    }

    /**
     * 获取：业务id
     */
    public Long getBusId() {
        return busId;
    }

    /**
     * 设置：业务表名
     */
    public void setBusId(Long busId) {
        this.busId = busId;
    }

    /**
     * 获取：文件名称
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置：文件名称
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 获取：文件大小
     */
    public Long getFileSize() {
        return fileSize;
    }

    /**
     * 设置：文件大小
     */
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * 获取：创建人id
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 设置：创建人id
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 获取：创建人名称
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 设置：创建人名称
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    /**
     * 获取：创建人部门id
     */
    public Long getCreateDeptId() {
        return createDeptId;
    }

    /**
     * 设置：创建人部门id
     */
    public void setCreateDeptId(Long createDeptId) {
        this.createDeptId = createDeptId;
    }

    /**
     * 获取：创建人部门名称
     */
    public String getCreateDeptName() {
        return createDeptName;
    }

    /**
     * 设置：创建人部门名称
     */
    public void setCreateDeptName(String createDeptName) {
        this.createDeptName = createDeptName;
    }

    @Override
    public String toString() {
        return "FileDO{" +
                "id=" + id +
                ", busType='" + busType + '\'' +
                ", busId=" + busId +
                ", type=" + type +
                ", fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +
                ", createUserId=" + createUserId +
                ", createUserName='" + createUserName + '\'' +
                ", createDeptId=" + createDeptId +
                ", createDeptName='" + createDeptName + '\'' +
                ", url='" + url + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
