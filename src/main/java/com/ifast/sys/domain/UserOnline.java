package com.ifast.sys.domain;

import java.util.Date;

/**
 * <pre>
 * </pre>
 * <small> 2018年3月23日 | Aron</small>
 */
public class UserOnline {

    /**
     */
    private String id;
    
    /**
     * 用户id
     */
    private String userId;
    
    /**
     * 用户名
     */
    private String username;

    /**
     * 用户主机地址
     */
    private String host;

    /**
     * 用户登录时系统IP
     */
    private String systemHost;

    /**
     * 用户浏览器类型
     */
    private String userAgent;

    /**
     * 在线状态
     */
    private String status = "on_line";

    /**
     * session创建时间
     */
    private Date startTimestamp;
    /**
     * session最后访问时间
     */
    private Date lastAccessTime;

    /**
     * 超时时间
     */
    private Long timeout;

    /**
     * 备份的当前用户会话
     */
    private String onlineSession;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * 获取session创建时间
     */
    public Date getStartTimestamp() {
        return startTimestamp;
    }
    
    /**
     * 设置session创建时间
     */
    public void setStartTimestamp(Date startTimestamp) {
        this.startTimestamp = startTimestamp;
    }
    
    /**
     * 获取最后访问时间
     */
    public Date getLastAccessTime() {
        return lastAccessTime;
    }
    
    /**
     * 设置最后访问时间
     */
    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }
    
    /**
     * 获取超时时间
     */
    public Long getTimeout() {
        return timeout;
    }
    
    /**
     * 设置超时时间
     */
    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }
    
    /**
     * 获取主机名
     */
    public String getHost() {
        return host;
    }
    
    /**
     * 设置主机名
     */
    public void setHost(String host) {
        this.host = host;
    }
    
    /**
     * 获取用户id
     */
    public String getUserId() {
        return userId;
    }
    
    /**
     * 设置用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    /**
     * 获取用户名
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * 设置用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * 获取用户浏览器类型
     */
    public String getUserAgent() {
        return userAgent;
    }
    
    /**
     * 设置用户浏览器类型
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
    
    /**
     * 获取在线状态
     */
    public String getStatus() {
        return status;
    }
    
    /**
     * 设置在线状态
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    /**
     * 获取备份的当前用户会话
     */
    public String getOnlineSession() {
        return onlineSession;
    }
    
    /**
     * 设置备份的当前用户会话
     */
    public void setOnlineSession(String onlineSession) {
        this.onlineSession = onlineSession;
    }

    /**
     * 获取用户登录时系统IP
     */
    public String getSystemHost() {
        return systemHost;
    }
    
    /**
     * 设置用户登录时系统IP
     */
    public void setSystemHost(String systemHost) {
        this.systemHost = systemHost;
    }



}
