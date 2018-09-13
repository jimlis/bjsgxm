package com.ifast.sys.service;

import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ifast.common.base.CoreService;
import com.ifast.common.domain.Tree;
import com.ifast.sys.domain.DeptDO;
import com.ifast.sys.domain.UserDO;
import com.ifast.sys.vo.UserVO;

/**
 * <pre>
 * </pre>
 * 
 * <small> 2018年3月23日 | Aron</small>
 */
@Service("sysUserService")
public interface UserService extends CoreService<UserDO> {
	 /**
     * 根据参数判断用户是否存在
     * @return true--存在 false-不存
     */
    boolean exit(Map<String, Object> params);

    Set<String> listRoles(Long userId);
    
    /**
     * 修改密码
     */
    int resetPwd(UserVO userVO, UserDO userDO);

    int adminResetPwd(UserVO userVO);

    Tree<DeptDO> getTree();

    /**
     * 更新个人信息
     * 
     * @param userDO
     * @return
     */
    int updatePersonal(UserDO userDO);


}
