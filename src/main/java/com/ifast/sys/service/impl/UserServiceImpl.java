package com.ifast.sys.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ifast.common.base.CoreServiceImpl;
import com.ifast.common.domain.Tree;
import com.ifast.common.exception.IFastException;
import com.ifast.common.type.EnumErrorCode;
import com.ifast.common.utils.BuildTree;
import com.ifast.common.utils.FileType;
import com.ifast.common.utils.FileUtil;
import com.ifast.common.utils.ImageUtils;
import com.ifast.common.utils.MD5Utils;
import com.ifast.oss.domain.FileDO;
import com.ifast.oss.service.FileService;
import com.ifast.sys.dao.DeptDao;
import com.ifast.sys.dao.UserDao;
import com.ifast.sys.dao.UserRoleDao;
import com.ifast.sys.domain.DeptDO;
import com.ifast.sys.domain.UserDO;
import com.ifast.sys.domain.UserRoleDO;
import com.ifast.sys.service.UserService;
import com.ifast.sys.vo.UserVO;

/**
 * <pre>
 * </pre>
 * 
 * <small> 2018年3月23日 | Aron</small>
 */
@Transactional
@Service("sysUserServiceImpl")
public class UserServiceImpl extends CoreServiceImpl<UserDao, UserDO> implements UserService {
    @Autowired
    UserRoleDao userRoleMapper;
    @Autowired
    DeptDao deptMapper;
    @Autowired
    private FileService sysFileService;
    
    @Override
    public UserDO selectById(Serializable id) {
    	//查询用户拥有的角色
        List<Long> roleIds = userRoleMapper.listRoleId(id);
        UserDO user = baseMapper.selectById(id);
        user.setDeptName(deptMapper.selectById(user.getDeptId()).getName());
        user.setroleIds(roleIds);
        return user;
    }

    @Transactional
    @Override
    public boolean insert(UserDO user) {
        int count = baseMapper.insert(user);
        Long userId = user.getId();
        List<Long> roles = user.getroleIds();
        //删除原来的角色
        userRoleMapper.removeByUserId(userId);
        List<UserRoleDO> list = new ArrayList<>();
        for (Long roleId : roles) {
            UserRoleDO ur = new UserRoleDO();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            list.add(ur);
        }
        if (list.size() > 0) {
        	//插入用户角色
            userRoleMapper.batchSave(list);
        }
        return retBool(count);
    }

    @Override
    public boolean updateById(UserDO user) {
        int r = baseMapper.updateById(user);
        Long userId = user.getId();
        List<Long> roles = user.getroleIds();
        //删除原来的角色
        userRoleMapper.removeByUserId(userId);
        List<UserRoleDO> list = new ArrayList<>();
        for (Long roleId : roles) {
            UserRoleDO ur = new UserRoleDO();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            list.add(ur);
        }
        if (list.size() > 0) {
        	//插入用户角色
            userRoleMapper.batchSave(list);
        }
        return retBool(r);
    }

    @Override
    public boolean deleteById(Serializable userId) {
    	//删除原来的角色
        userRoleMapper.removeByUserId(userId);
        return retBool(baseMapper.deleteById(userId));
    }
    
    /**
     * 根据参数判断用户是否存在
     * @return true--存在 false-不存
     */
    @Override
    public boolean exit(Map<String, Object> params) {
        return retBool(baseMapper.selectByMap(params).size());
    }

    @Override
    public Set<String> listRoles(Long userId) {
        return null;
    }
    
    /**
     * 修改密码
     */
    @Override
    public int resetPwd(UserVO userVO, UserDO userDO) {
        if (Objects.equals(userVO.getUserDO().getId(), userDO.getId())) {
            if (Objects.equals(MD5Utils.encrypt(userDO.getUsername(), userVO.getPwdOld()), userDO.getPassword())) {
                userDO.setPassword(MD5Utils.encrypt(userDO.getUsername(), userVO.getPwdNew()));
                return baseMapper.updateById(userDO);
            } else {
                throw new IFastException("输入的旧密码有误！");
            }
        } else {
            throw new IFastException("你修改的不是你登录的账号！");
        }
    }

    @Override
    public int adminResetPwd(UserVO userVO) {
        UserDO userDO = selectById(userVO.getUserDO().getId());
        if ("admin".equals(userDO.getUsername())) {
            throw new IFastException(EnumErrorCode.userUpdatePwd4adminNotAllowed.getCodeStr());
        }
        userDO.setPassword(MD5Utils.encrypt(userDO.getUsername(), userVO.getPwdNew()));
        return baseMapper.updateById(userDO);

    }

    @Transactional
    @Override
    public boolean deleteBatchIds(List<? extends Serializable> idList) {
        int count = baseMapper.deleteBatchIds(idList);
        userRoleMapper.deleteBatchIds(idList);
        return retBool(count);
    }
    
    /**
     * 查询用户机构树
     */
    @Override
    public Tree<DeptDO> getTree() {
        List<Tree<DeptDO>> trees = new ArrayList<Tree<DeptDO>>();
        List<DeptDO> depts = deptMapper.selectList(null);//所有部门id
        Long[] pDepts = deptMapper.listParentDept();//所有部门parentid
        Long[] uDepts = baseMapper.listAllDept();//用户存在的部门集合
        Long[] allDepts = (Long[]) ArrayUtils.addAll(pDepts, uDepts);
        for (DeptDO dept : depts) {
        	//去除
            if (!ArrayUtils.contains(allDepts, dept.getId())) {
                continue;
            }
            Tree<DeptDO> tree = new Tree<DeptDO>();
            tree.setId(dept.getId().toString());
            tree.setParentId(dept.getParentId().toString());
            tree.setText(dept.getName());
            Map<String, Object> state = new HashMap<>(16);
            state.put("opened", true);
            state.put("mType", "dept");
            tree.setState(state);
            trees.add(tree);
        }
        List<UserDO> users = baseMapper.selectList(null);
        for (UserDO user : users) {
            Tree<DeptDO> tree = new Tree<DeptDO>();
            tree.setId(user.getId().toString());
            tree.setParentId(user.getDeptId().toString());
            tree.setText(user.getName());
            Map<String, Object> state = new HashMap<>(16);
            state.put("opened", true);
            state.put("mType", "user");
            tree.setState(state);
            trees.add(tree);
        }
        // 默认顶级菜单为０，根据数据库实际情况调整
        Tree<DeptDO> t = BuildTree.build(trees);
        return t;
    }
    
    /**
     * 更新个人信息
     * 
     * @param userDO
     * @return
     */
    @Override
    public int updatePersonal(UserDO userDO) {
        return baseMapper.updateById(userDO);
    }
    


}
