package com.ifast.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ifast.common.base.BaseDao;
import com.ifast.sys.domain.DeptDO;

/**
 * <pre>
 * 部门管理
 * </pre>
 * <small> 2018年3月23日 | Aron</small>
 */
public interface DeptDao extends BaseDao<DeptDO> {
	
	Long[] listParentDept();
	
	int getDeptUserNumber(Long deptId);
	
	/**
	 * 根据部门id获取下一级部门和人员信息
	 * @param deptId 部门id
	 * @return 部门、人员集合
	 */
	List<Map<String,Object>> getNextDeptAndUser(@Param("deptId") Long deptId);
}
