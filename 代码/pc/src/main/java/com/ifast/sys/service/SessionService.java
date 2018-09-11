package com.ifast.sys.service;

import java.util.Collection;
import java.util.List;

import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;

import com.ifast.sys.domain.UserOnline;

/**
 * <pre>
 * </pre>
 * <small> 2018年3月23日 | Aron</small>
 */
@Service
public interface SessionService {
	

	/**
	 * 查询在线用户集合
	 * @return 在线用户集合
	 */
	List<UserOnline> list();

	Collection<Session> sessionList();
	

	/**
	 * 设置sessionc超时时间
	 * @return true
	 */
	boolean forceLogout(String sessionId);
}
