package com.ifast.common.domain;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;


/**
 * @author Aron
 * @email izenglong@163.com
 * @date 2018-04-06 01:05:22
 */
@TableName("sys_config")
public class ConfigDO extends Model<ConfigDO> implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    
    /**  */
    @TableId
    private Long id;
    /** 键 */
    private String k;
    /** 值 */
    private String v;
    /** 备注 */
    private String remark;
    /** 创建时间 */
    private Date createTime;
    /** 类型 */
    private Integer kvType;
    
    
    @Override
    public String toString() {
        return "ConfigDO{" +
                "id=" + id +
                ", k='" + k + '\'' +
                ", v='" + v + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", kvType=" + kvType +
                '}';
    }
    
    /**
     * 获取kv类型
     */
    public Integer getKvType() {
        return kvType;
    }
    
    /**
     * 设置kv类型
     */
    public void setKvType(Integer kvType) {
        this.kvType = kvType;
    }
    
    /**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * 获取：id
     */
    public Long getId() {
        return id;
    }
    
    /**
     * 设置：id
     */
    public void setK(String k) {
        this.k = k;
    }
    
    /**
     * 获取：键
     */
    public String getK() {
        return k;
    }
    
    /**
     * 设置：键
     */
    public void setV(String v) {
        this.v = v;
    }
    
    /**
     * 获取：值
     */
    public String getV() {
        return v;
    }
    
    /**
     * 设置：值
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    /**
     * 获取：备注
     */
    public String getRemark() {
        return remark;
    }
    
    /**
     * 设置：备注
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    /**
     * 获取：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }
    
    @Override
    protected Serializable pkVal() {
        // TODO Auto-generated method stub
        return null;
    }
}
