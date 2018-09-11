package com.ifast.sys.service;

import java.util.List;
import java.util.Map;

import com.ifast.common.base.CoreService;
import com.ifast.common.domain.Tree;
import com.ifast.sys.domain.DeptDO;

/**
 * <pre>
 * 部门管理
 * </pre>
 * <small> 2018年3月23日 | Aron</small>
 */
public interface DeptService extends CoreService<DeptDO> {
    
	/**
	 * 获取部门树
	 * @return Tree
	 */
	Tree<DeptDO> getTree();
	
	/**
	 * 检查部门下是否有用户
	 * @param deptId 部门id
	 * @return true-不存在 false-存在
	 */
	boolean checkDeptHasUser(Long deptId);
	
	/**
	 * 根据部门id获取下一级部门和人员信息
	 * @param deptId 部门id
	 * @return 部门、人员集合
	 */
	List<Map<String,Object>> getNextDeptAndUser(Long deptId);
}
