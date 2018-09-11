package com.ifast.sys.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <pre>
 * </pre>
 * <small> 2018年3月23日 | Aron</small>
 */
@TableName("sys_user")
public class UserDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户真实姓名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 部门
     */
    private Long deptId;
    /**
     * 部门名称
     */
    @TableField(exist = false)
    private String deptName;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 状态 0:禁用，1:正常
     */
    private Integer status;
    /**
     * 排序号
     */
    private Long orderNum;
    
    /**
     * 创建用户id
     */
    private Long userIdCreate;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date gmtModified;
    /**
     * 角色集合
     */
    @TableField(exist = false)
    private List<Long> roleIds;
    /**
     * 性别
     */
    private Long sex;
    /**
     * 出身日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    /**
     * 图片ID
     */
    private Long picId;
    /**
     * 现居住地
     */
    private String liveAddress;
    /**
     * 爱好
     */
    private String hobby;
    /**
     * 省份
     */
    private String province;
    /**
     * 所在城市
     */
    private String city;
    /**
     * 所在地区
     */
    private String district;

    

    /**
     * 设置：用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取：用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 获取：用户姓名
     */
    public String getName() {
        return name;
    }
    
    /**
     * 设置：用户姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 设置：密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取：密码
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * 获取部门id
     */
    public Long getDeptId() {
        return deptId;
    }
    
    /**
     * 设置部门id
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }
    
    /**
     * 获取部门名称
     * @return
     */
    public String getDeptName() {
        return deptName;
    }
    
    /**
     * 设置部门名称
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 设置：邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取：邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置：手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取：手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置：状态 0:禁用，1:正常
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：状态 0:禁用，1:正常
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置：创建用户id
     */
    public void setUserIdCreate(Long userIdCreate) {
        this.userIdCreate = userIdCreate;
    }

    /**
     * 获取：创建用户id
     */
    public Long getUserIdCreate() {
        return userIdCreate;
    }

    /**
     * 设置：创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取：创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置：修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取：修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }
    
    /**
     * 获取角色集合
     */
    public List<Long> getroleIds() {
        return roleIds;
    }
    
    /**
     * 设置用户集合
     */
    public void setroleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }
    
    /**
     * 获取性别
     */
    public Long getSex() {
        return sex;
    }
    
    /**
     * 设置用户性别
     */
    public void setSex(Long sex) {
        this.sex = sex;
    }
    
    /**
     * 获取出生日期
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * 设置出生日期
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }
    
    /**
     * 获取图片id
     */
    public Long getPicId() {
        return picId;
    }
    
    /**
     * 设置图片id
     */
    public void setPicId(Long picId) {
        this.picId = picId;
    }
    
    /**
     * 获取居住地址
     */
    public String getLiveAddress() {
        return liveAddress;
    }
    
    /**
     * 设置居住地址
     */
    public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress;
    }
    
    /**
     * 获取爱好
     */
    public String getHobby() {
        return hobby;
    }
    
    /**
     * 设置爱好
     */
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    
    /**
     * 获取省份
     */
    public String getProvince() {
        return province;
    }
    
    /**
     * 设置省份
     */
    public void setProvince(String province) {
        this.province = province;
    }
    
    /**
     * 获取所在城市
     */
    public String getCity() {
        return city;
    }
    
    /**
     * 设置所在城市
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    /**
     * 获取所在地区
     */
    public String getDistrict() {
        return district;
    }
    
    /**
     * 设置所在地区
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	@Override
    public String toString() {
        return "UserDO [id=" + id + ", username=" + username + ", name=" + name + ", password=" + password + ", deptId="
                + deptId + ", deptName=" + deptName + ", email=" + email + ", mobile=" + mobile + ", status=" + status
                + ", userIdCreate=" + userIdCreate + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified
                + ", roleIds=" + roleIds + ", sex=" + sex + ", birth=" + birth + ", picId=" + picId + ", liveAddress="
                + liveAddress + ", hobby=" + hobby + ", province=" + province + ", city=" + city + ", district="
                + district+ ", orderNum=" + orderNum + "]";
    }

    
}
