package com.ifast.sys.domain;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <pre>
 * </pre>
 * <small> 2018年3月23日 | Aron</small>
 */
@TableName("sys_role_menu")
public class RoleMenuDO {
	private Long id;
	/**
	 * 角色id
	 */
	private Long  roleId;
	/**
	 * 菜单id
	 */
	private Long menuId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	/**
	 * 获取菜单id
	 */
	public Long getMenuId() {
		return menuId;
	}
	/**
	 * 设置菜单id
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	@Override
	public String toString() {
		return "RoleMenuDO{" +
				"id=" + id +
				", roleId=" + roleId +
				", menuId=" + menuId +
				'}';
	}
}
