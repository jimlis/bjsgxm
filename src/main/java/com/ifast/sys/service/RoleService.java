package com.ifast.sys.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ifast.common.base.CoreService;
import com.ifast.sys.domain.RoleDO;

/**
 * <pre>
 * </pre>
 * <small> 2018年3月23日 | Aron</small>
 */
@Service
public interface RoleService extends CoreService<RoleDO> {
	/**
     * 查找所有角色列表
     */
    List<RoleDO> findAll();
    
    /**
     * 根据用户id查询角色列表
     * @param userId 用户id
     * @return 角色列表
     */
    List<RoleDO> findListByUserId(Serializable id);
}
