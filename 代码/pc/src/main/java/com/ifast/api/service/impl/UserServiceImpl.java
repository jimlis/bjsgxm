package com.ifast.api.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ifast.api.config.JWTConfig;
import com.ifast.api.exception.IFastApiException;
import com.ifast.api.pojo.vo.TokenVO;
import com.ifast.api.service.UserService;
import com.ifast.api.util.JWTUtil;
import com.ifast.common.base.CoreServiceImpl;
import com.ifast.common.config.CacheConfiguration;
import com.ifast.common.config.IFastConfig;
import com.ifast.common.type.EnumErrorCode;
import com.ifast.common.utils.MD5Utils;
import com.ifast.common.utils.SpringContextHolder;
import com.ifast.sys.dao.UserDao;
import com.ifast.sys.domain.UserDO;

/**
 * <pre>
 * </pre>
 * 
 * <small> 2018年4月27日 | Aron</small>
 */
@Service
public class UserServiceImpl extends CoreServiceImpl<UserDao,UserDO> implements UserService {
	/** Holder for lazy-init */
	private static class Holder {
		static final JWTConfig jwt = SpringContextHolder.getBean(IFastConfig.class).getJwt();
		static final Cache logoutTokens = CacheConfiguration.dynaConfigCache("tokenExpires", 0, jwt.getRefreshTokenExpire(), 1000);
		static {
			JWTUtil.mykey = jwt.getUserPrimaryKey();
		}
	}

	@Override
    public TokenVO getToken(String mobile, String password) {
        UserDO user = selectOne(new EntityWrapper<UserDO>().eq("mobile", mobile));
        if (null == user || !user.getPassword().equals(MD5Utils.encrypt(user.getUsername(), password))) {
            throw new IFastApiException(EnumErrorCode.apiAuthorizationLoginFailed.getCodeStr());
        }
        return createToken(user);
    }

    @Override
	public boolean verifyToken(String token, boolean refresh) {
    	String userId = null; 
    	UserDO user = null;
    	return StringUtils.isNotBlank(token)
    			&& (userId=JWTUtil.getUserId(token))!=null
    			&& notLogout(token)
    			&& (user=refresh?selectOne(new EntityWrapper<UserDO>().eq("mobile", userId)):selectById(userId))!=null
    			&& (refresh ? JWTUtil.verify(token, user.getMobile(), user.getId()+user.getPassword()) : JWTUtil.verify(token, userId, user.getMobile()+user.getPassword()));
	}

	@Override
	public TokenVO refreshToken(String mobile, String refreshToken) {
		UserDO user = null;
		if(StringUtils.isNotBlank(refreshToken)
				&& mobile.equals(JWTUtil.getUserId(refreshToken))
				&& notLogout(refreshToken)
				&& (user=selectOne(new EntityWrapper<UserDO>().eq("mobile", mobile)))!=null
				&& JWTUtil.verify(refreshToken, user.getMobile(), user.getId()+user.getPassword())
				&& Holder.logoutTokens.putIfAbsent(refreshToken, null)==null) {
			return createToken(user);
		}
    	throw new IFastApiException(EnumErrorCode.apiAuthorizationInvalid.getCodeStr());
	}

	@Override
	public Boolean logoutToken(String token, String refreshToken) {
		Boolean expire = Boolean.FALSE; String userId = null, mobile = null; 
		UserDO user = null;
		if(StringUtils.isNotBlank(token)
				&& (userId=JWTUtil.getUserId(token))!=null
				&& Holder.logoutTokens.get(token)==null
				&& (user=selectById(userId))!=null
				&& JWTUtil.verify(token, userId, user.getMobile()+user.getPassword())
				&& Holder.logoutTokens.putIfAbsent(token, null)==null) {
			expire = Boolean.TRUE;
		}
		if(StringUtils.isNotBlank(refreshToken)
				&& (mobile=JWTUtil.getUserId(refreshToken))!=null
				&& Holder.logoutTokens.get(refreshToken)==null
				&& (user!=null || (user=selectOne(new EntityWrapper<UserDO>().eq("mobile", mobile)))!=null)
				&& JWTUtil.verify(refreshToken, user.getMobile(), user.getId()+user.getPassword())
				&& Holder.logoutTokens.putIfAbsent(refreshToken, null)==null) {
			expire = Boolean.TRUE;
		}
		return expire;
	}

	private TokenVO createToken(UserDO user) {
        TokenVO vo = new TokenVO();
        vo.setToken(JWTUtil.sign(user.getId() + "", user.getMobile() + user.getPassword(), Holder.jwt.getExpireTime()));
        vo.setRefleshToken(JWTUtil.sign(user.getMobile(), user.getId() + user.getPassword(), Holder.jwt.getExpireTime()));
        vo.setTokenExpire(Holder.jwt.getExpireTime());
        vo.setRefreshTokenExpire(Holder.jwt.getRefreshTokenExpire());
        return vo;
	}
	
	private boolean notLogout(String token) {
		if(Holder.logoutTokens.get(token)!=null)
			throw new IFastApiException(EnumErrorCode.apiAuthorizationLoggedout.getMsg());
		return true;
	}
}
