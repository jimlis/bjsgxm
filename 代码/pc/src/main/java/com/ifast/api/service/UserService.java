package com.ifast.api.service;

import com.ifast.api.pojo.vo.TokenVO;
import com.ifast.common.base.CoreService;
import com.ifast.sys.domain.UserDO;

/**
 * <pre>
 * </pre>
 * <small> 2018年4月27日 | Aron</small>
 */
public interface UserService extends CoreService<UserDO> {
    /** 申请token */
    TokenVO getToken(String uname, String passwd) ;
    /** 刷新token */
    TokenVO refreshToken(String uname, String refreshToken);
    /** 检查token是否有效：未超时、未注销*/
    boolean verifyToken(String token, boolean refresh);
    /** 注销token */
    Boolean logoutToken(String token, String refreshToken);
}
