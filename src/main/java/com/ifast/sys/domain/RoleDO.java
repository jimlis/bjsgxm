package com.ifast.sys.domain;

import java.sql.Timestamp;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <pre>
 * </pre>
 * <small> 2018年3月23日 | Aron</small>
 */
@TableName("sys_role")
public class RoleDO {

    private Long id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色标识
     */
    private String roleSign;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建用户id
     */
    private Long userIdCreate;
    /**
     * 创建时间
     */
    private Timestamp gmtCreate;
    /**
     * 修改时间
     */
    private Timestamp gmtModified;
    /**
     * 菜单集合
     */
    @TableField(exist = false)
    private List<Long> menuIds;
    
    /**
     * 获取角色名称
     */
    public String getRoleName() {
        return roleName;
    }
    
    /**
     * 设置角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    /**
     * 获取角色标识
     */
    public String getRoleSign() {
        return roleSign;
    }
    
    /**
     * 设置角色名称
     */
    public void setRoleSign(String roleSign) {
        this.roleSign = roleSign;
    }
    
    /**
     * 获取备注
     */
    public String getRemark() {
        return remark;
    }
    
    /**
     * 设置备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    /**
     * 获取创建用户id
     */
    public Long getUserIdCreate() {
        return userIdCreate;
    }
    
    /**
     * 设置创建用户id
     */
    public void setUserIdCreate(Long userIdCreate) {
        this.userIdCreate = userIdCreate;
    }
    
    /**
     * 获取创建时间
     */
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }
    
    /**
     * 设置创建时间
     */
    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
    
    /**
     * 获取更新时间
     */
    public Timestamp getGmtModified() {
        return gmtModified;
    }
    
    /**
     * 设置更新时间
     */
    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }
    
    /**
     * 获取菜单集合
     */
    public List<Long> getMenuIds() {
        return menuIds;
    }
    
    /**
     * 设置菜单集合
     */
    public void setMenuIds(List<Long> menuIds) {
        this.menuIds = menuIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RoleDO [id=" + id + ", roleName=" + roleName + ", roleSign=" + roleSign + ", remark=" + remark
                + ", userIdCreate=" + userIdCreate + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified
                + ", menuIds=" + menuIds + "]";
    }

}
