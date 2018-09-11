package com.ifast.api.pojo.dto;  
  
/**
 * <pre>
 * </pre>
 * <small> 2018年4月18日 | Aron</small>
 */
public class LoginParamDTO {  
	/**
	 * 客户端id
	 */
    private String clientId;  
    /**
     * 用户名
     */
    private String userName;  
    /**
     * 密码
     */
    private String password;  
    private String captchaCode;  
    private String captchaValue;  
     
    /**
     * 获取客户端ip
     * @return
     */
    public String getClientId() {  
        return clientId;  
    }  
    
    /**
     * 设置客户端ip
     * @return
     */
    public void setClientId(String clientId) {  
        this.clientId = clientId;  
    }  
    
    /**
     * 获取用户名
     * @return
     */
    public String getUserName() {  
        return userName;  
    }  
    
    /**
     * 设置用户名
     * @param userName
     */
    public void setUserName(String userName) {  
        this.userName = userName;  
    }  
    public String getPassword() {  
        return password;  
    }  
    public void setPassword(String password) {  
        this.password = password;  
    }  
    public String getCaptchaCode() {  
        return captchaCode;  
    }  
    public void setCaptchaCode(String captchaCode) {  
        this.captchaCode = captchaCode;  
    }  
    public String getCaptchaValue() {  
        return captchaValue;  
    }  
    public void setCaptchaValue(String captchaValue) {  
        this.captchaValue = captchaValue;  
    }  
}