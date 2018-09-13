package com.project.gsggNr.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;



/**
 * 
 * <pre>
 * 公司公告-内容
 * </pre>
 * <small> 2018-09-13 20:26:41 | lijun</small>
 */
 @TableName("bj_gsgg_nr")
public class GsggNrDO implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    
    /** 主键id */
    @TableId
    private Long id;
    /** 逻辑废除：0（废除），1（正常） */
    private Integer fcbz;
    /** 修改新增删除时间 */
    private Date gxsj;
    /** 公司公告id：bj_gsgg表 */
    private Long intggid;
    /** 公告内容 */
    private String chrggnr;

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
     * 设置：公司公告id：bj_gsgg表
     */
    public void setIntggid(Long intggid) {
        this.intggid = intggid;
    }
    /**
     * 获取：公司公告id：bj_gsgg表
     */
    public Long getIntggid() {
        return intggid;
    }
    /**
     * 设置：公告内容
     */
    public void setChrggnr(String chrggnr) {
        this.chrggnr = chrggnr;
    }
    /**
     * 获取：公告内容
     */
    public String getChrggnr() {
        return chrggnr;
    }
}
