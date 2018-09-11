package com.ifast.sys.domain;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <pre>
 * </pre>
 * <small> 2018年3月23日 | Aron</small>
 */
@TableName("sys_user_role")
public class UserRoleDO {
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 角色id
     */
    private Long roleId;
    
    /**
     * 获取用户角色id
     */
    public Long getId() {
        return id;
    }
    
    /**
     * 设置用户角色id 
     */
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
     * 获取角色id
     */
    public Long getRoleId() {
        return roleId;
    }
    
    /**
     * 设置角色id
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRoleDO{" +
                "id=" + id +
                ", userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
