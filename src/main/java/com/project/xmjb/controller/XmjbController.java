package com.project.xmjb.controller;


import java.util.Arrays;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ifast.common.base.AdminBaseController;
import com.project.xmjb.domain.XmjbDO;
import com.project.xmjb.service.XmjbService;
import com.ifast.common.utils.Result;

/**
 * 
 * <pre>
 * 项目基本，所有项目相关表的主表
 * </pre>
 * <small> 2018-09-12 23:09:04 | lijun</small>
 */
@Controller
@RequestMapping("/project/xmjb")
public class XmjbController extends AdminBaseController {
	@Autowired
	private XmjbService xmjbService;
	
	@GetMapping()
	@RequiresPermissions("project:xmjb:xmjb")
	String Xmjb(){
	    return "project/xmjb/xmjb";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("project:xmjb:xmjb")
	public Result<Page<XmjbDO>> list(XmjbDO xmjbDTO){
        Wrapper<XmjbDO> wrapper = new EntityWrapper<XmjbDO>(xmjbDTO);
        Page<XmjbDO> page = xmjbService.selectPage(getPage(XmjbDO.class), wrapper);
        return Result.ok(page);
	}
	
	@GetMapping("/add")
	@RequiresPermissions("project:xmjb:add")
	String add(){
	    return "project/xmjb/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("project:xmjb:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		XmjbDO xmjb = xmjbService.selectById(id);
		model.addAttribute("xmjb", xmjb);
	    return "project/xmjb/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("project:xmjb:add")
	public Result<String> save( XmjbDO xmjb){
		xmjbService.insert(xmjb);
        return Result.ok();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("project:xmjb:edit")
	public Result<String>  update( XmjbDO xmjb){
		xmjbService.updateById(xmjb);
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("project:xmjb:remove")
	public Result<String>  remove( Integer id){
		xmjbService.deleteById(id);
        return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("project:xmjb:batchRemove")
	public Result<String>  remove(@RequestParam("ids[]") Integer[] ids){
		xmjbService.deleteBatchIds(Arrays.asList(ids));
		return Result.ok();
	}

	@ResponseBody
	@RequestMapping("/listAll")
	public List<XmjbDO> listAll(XmjbDO xmjbDTO){
		Wrapper<XmjbDO> wrapper = new EntityWrapper<XmjbDO>(xmjbDTO).eq("fcbz","1");;
		List<XmjbDO> list = xmjbService.selectList(wrapper);
		return list;
	}
	
}
