package com.ifast.sys.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.ifast.common.base.CoreService;
import com.ifast.common.domain.Tree;
import com.ifast.sys.domain.MenuDO;

/**
 * <pre>
 * </pre>
 * <small> 2018年3月23日 | Aron</small>
 */
@Service
public interface MenuService extends CoreService<MenuDO> {
	
	 /**
     * 根据用户id获取树形目录、菜单
     * @param id 用户id
     * @return 树形菜单
     */
    Tree<MenuDO> getSysMenuTree(Long id);
    
    /**
     * 根据用户id获取树形目录、菜单
     * @param id 用户id
     * @return 树形菜单
     */
    List<Tree<MenuDO>> listMenuTree(Long id);
    
    /**
     * 查询所有菜单
     * @return 树形菜单
     */
    Tree<MenuDO> getTree();
    
    /**
     * 根据角色id(roleId)获取树形菜单
     * @param id 用户id
     * @return 树形菜单
     */
    Tree<MenuDO> getTree(Long id);
    
    /**
     * 根据用户id获取树形目录、菜单、按钮
     * @param id 用户id
     * @return 树形菜单
     */
    Set<String> listPerms(Long userId);
}
