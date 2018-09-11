package com.ifast.common.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.ifast.api.util.JWTUtil;
import com.ifast.sys.dao.UserDao;
import com.ifast.sys.domain.UserDO;

public class ShiroUtils {
	public static Subject getSubjct() {
		return SecurityUtils.getSubject();
	}
	
	// api
	private final static UserDao userDao = SpringContextHolder.getBean(UserDao.class);
	public static UserDO getAppUserDO() {
	    String jwt = (String)getSubjct().getPrincipal();
	    String userId = JWTUtil.getUserId(jwt);
	    return userDao.selectById(userId);
	}
	
	// admin
	public static UserDO getSysUser() {
		return (UserDO)getSubjct().getPrincipal();
	}
	public static Long getUserId() {
		return getSysUser().getId();
	}
	
	public static void logout() {
		getSubjct().logout();
	}
}
