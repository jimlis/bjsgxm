package com.project.wdb.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;



/**
 * 
 * <pre>
 * 
 * </pre>
 * <small> 2018-09-09 20:40:48 | lijun</small>
 */
 @TableName("bj_wdb")
public class WdbDO implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    
    /**  */
    @TableId
    private Long id;
    /** 项目id */
    private Long xmid;
    /** 项目名称 */
    private String xmmc;
    /** 类型编号 */
    private String type;
    /** 类型名称 */
    private String typeName;
    /** 文件名称 */
    private String fileName;
    /** 废除标志 1正常0 废除 */
    private Integer fcbz;

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
     * 设置：项目id
     */
    public void setXmid(Long xmid) {
        this.xmid = xmid;
    }
    /**
     * 获取：项目id
     */
    public Long getXmid() {
        return xmid;
    }
    /**
     * 设置：项目名称
     */
    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }
    /**
     * 获取：项目名称
     */
    public String getXmmc() {
        return xmmc;
    }
    /**
     * 设置：类型编号
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * 获取：类型编号
     */
    public String getType() {
        return type;
    }
    /**
     * 设置：类型名称
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    /**
     * 获取：类型名称
     */
    public String getTypeName() {
        return typeName;
    }
    /**
     * 设置：文件名称
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    /**
     * 获取：文件名称
     */
    public String getFileName() {
        return fileName;
    }
    /**
     * 设置：废除标志 1正常0 废除
     */
    public void setFcbz(Integer fcbz) {
        this.fcbz = fcbz;
    }
    /**
     * 获取：废除标志 1正常0 废除
     */
    public Integer getFcbz() {
        return fcbz;
    }
}
