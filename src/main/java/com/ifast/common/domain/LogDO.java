package com.ifast.common.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <pre>
 * </pre>
 * <small> 2018年3月23日 | Aron</small>
 */
@TableName("sys_log")
public class LogDO extends Model<LogDO> implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = -938654836571738415L;
    
    @TableId
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 操作说明
     */
    private String operation;
    /**
     * 响应时间
     */
    private Integer time;
    /**
     * 方法名称
     */
    private String method;
    /**
     * 参数
     */
    private String params;
    /**
     * ip
     */
    private String ip;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 获取用户id
     */
    public Long getUserId() {
        return userId;
    }
    
    /**
     * 设置用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    /**
     * 获取用户名称
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * 设置用户名称
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
    
    /**
     * 获取用户操作
     */
    public String getOperation() {
        return operation;
    }
    
    /**
     * 设置用户操作
     */
    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }
    
    /**
     * 获取相应时间
     */
    public Integer getTime() {
        return time;
    }
    
    /**
     * 设置相应时间
     */
    public void setTime(Integer time) {
        this.time = time;
    }
    
    /**
     * 获取方法名称
     */
    public String getMethod() {
        return method;
    }
    
    /**
     * 设置方法名称
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }
    
    /**
     * 获取方法参数
     */
    public String getParams() {
        return params;
    }
    
    /**
     * 设置方法参数
     */
    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }
    
    /**
     * 获取用户ip
     */
    public String getIp() {
        return ip;
    }
    
    /**
     * 设置用户ip
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }
    
    /**
     * 获取创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }
    
    /**
     * 设置创建时间
     * @param gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Override
    public String toString() {
        return "LogDO{" + "id=" + id + ", userId=" + userId + ", username='" + username + '\'' + ", operation='"
                + operation + '\'' + ", time=" + time + ", method='" + method + '\'' + ", params='" + params + '\''
                + ", ip='" + ip + '\'' + ", gmtCreate=" + gmtCreate + '}';
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}