package com.ifast.api.pojo.dto;

import java.io.Serializable;

/**
 * <pre>
 * </pre>
 * 
 * <small> 2018年4月26日 | Aron</small>
 */
public class UserLoginDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户名
	 */
    private String uname;
    /**
     * 密码
     */
    private String passwd;
    
    /**
     * 获取用户名
     */
    public String getUname() {
        return uname;
    }
    
    /**
     * 设置用户名
     */
    public void setUname(String uname) {
        this.uname = uname;
    }
    
    /**
     * 获取密码
     * @return
     */
    public String getPasswd() {
        return passwd;
    }
    
    /**
     * 设置密码
     * @param passwd
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "UserLoginDTO [uname=" + uname + ", passwd=" + passwd + "]";
    }

}
