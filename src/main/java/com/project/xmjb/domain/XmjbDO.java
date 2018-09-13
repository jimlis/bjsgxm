package com.project.xmjb.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;



/**
 * 
 * <pre>
 * 项目基本，所有项目相关表的主表
 * </pre>
 * <small> 2018-09-12 23:09:04 | lijun</small>
 */
 @TableName("bj_xmjb")
public class XmjbDO implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    
    /** 主键id */
    @TableId
    private Long id;
    /** 逻辑废除：0（废除），1（正常） */
    private Integer fcbz;
    /** 修改新增删除时间 */
    private Date gxsj;
    /** 序号 */
    private Integer intxh;
    /** 项目名称 */
    private String chrxmmc;
    /** 项目类型:1(pmc项目)2（epc项目） */
    private Integer intxmlx;
    /** 登记时间 */
    private Date dtmdjsj;
    /** 登记人部门id */
    private Long intdjrbm;
    /** 登记人id */
    private Long intdjrid;
    /** 登记人名称 */
    private String chrdjrmc;
    /** 栋楼数 */
    private Integer intds;

    /**
     * 设置：主键id
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 获取：主键id
     */
    public Long getId() {
        return id;
    }
    /**
     * 设置：逻辑废除：0（废除），1（正常）
     */
    public void setFcbz(Integer fcbz) {
        this.fcbz = fcbz;
    }
    /**
     * 获取：逻辑废除：0（废除），1（正常）
     */
    public Integer getFcbz() {
        return fcbz;
    }
    /**
     * 设置：修改新增删除时间
     */
    public void setGxsj(Date gxsj) {
        this.gxsj = gxsj;
    }
    /**
     * 获取：修改新增删除时间
     */
    public Date getGxsj() {
        return gxsj;
    }
    /**
     * 设置：序号
     */
    public void setIntxh(Integer intxh) {
        this.intxh = intxh;
    }
    /**
     * 获取：序号
     */
    public Integer getIntxh() {
        return intxh;
    }
    /**
     * 设置：项目名称
     */
    public void setChrxmmc(String chrxmmc) {
        this.chrxmmc = chrxmmc;
    }
    /**
     * 获取：项目名称
     */
    public String getChrxmmc() {
        return chrxmmc;
    }
    /**
     * 设置：项目类型:1(pmc项目)2（epc项目）
     */
    public void setIntxmlx(Integer intxmlx) {
        this.intxmlx = intxmlx;
    }
    /**
     * 获取：项目类型:1(pmc项目)2（epc项目）
     */
    public Integer getIntxmlx() {
        return intxmlx;
    }
    /**
     * 设置：登记时间
     */
    public void setDtmdjsj(Date dtmdjsj) {
        this.dtmdjsj = dtmdjsj;
    }
    /**
     * 获取：登记时间
     */
    public Date getDtmdjsj() {
        return dtmdjsj;
    }
    /**
     * 设置：登记人部门id
     */
    public void setIntdjrbm(Long intdjrbm) {
        this.intdjrbm = intdjrbm;
    }
    /**
     * 获取：登记人部门id
     */
    public Long getIntdjrbm() {
        return intdjrbm;
    }
    /**
     * 设置：登记人id
     */
    public void setIntdjrid(Long intdjrid) {
        this.intdjrid = intdjrid;
    }
    /**
     * 获取：登记人id
     */
    public Long getIntdjrid() {
        return intdjrid;
    }
    /**
     * 设置：登记人名称
     */
    public void setChrdjrmc(String chrdjrmc) {
        this.chrdjrmc = chrdjrmc;
    }
    /**
     * 获取：登记人名称
     */
    public String getChrdjrmc() {
        return chrdjrmc;
    }
    /**
     * 设置：栋楼数
     */
    public void setIntds(Integer intds) {
        this.intds = intds;
    }
    /**
     * 获取：栋楼数
     */
    public Integer getIntds() {
        return intds;
    }
}
