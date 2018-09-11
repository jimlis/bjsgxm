package com.project.wdb.controller;


import java.util.Arrays;

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
import com.project.wdb.domain.WdbDO;
import com.project.wdb.service.WdbService;
import com.ifast.common.utils.Result;

/**
 * 
 * <pre>
 * 
 * </pre>
 * <small> 2018-09-09 20:40:48 | lijun</small>
 */
@Controller
@RequestMapping("/project/wdb")
public class WdbController extends AdminBaseController {
	@Autowired
	private WdbService wdbService;
	
	@GetMapping()
	@RequiresPermissions("project:wdb:wdb")
	String Wdb(){
	    return "project/wdb/wdb";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("project:wdb:wdb")
	public Result<Page<WdbDO>> list(WdbDO wdbDTO){
        Wrapper<WdbDO> wrapper = new EntityWrapper<WdbDO>(wdbDTO);
        Page<WdbDO> page = wdbService.selectPage(getPage(WdbDO.class), wrapper);
        return Result.ok(page);
	}
	
	@GetMapping("/add")
	@RequiresPermissions("project:wdb:add")
	String add(){
	    return "project/wdb/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("project:wdb:edit")
	String edit(@PathVariable("id") Long id,Model model){
		WdbDO wdb = wdbService.selectById(id);
		model.addAttribute("wdb", wdb);
	    return "project/wdb/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("project:wdb:add")
	public Result<String> save( WdbDO wdb){
		wdbService.insert(wdb);
        return Result.ok();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("project:wdb:edit")
	public Result<String>  update( WdbDO wdb){
		wdbService.updateById(wdb);
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("project:wdb:remove")
	public Result<String>  remove( Long id){
		wdbService.deleteById(id);
        return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("project:wdb:batchRemove")
	public Result<String>  remove(@RequestParam("ids[]") Long[] ids){
		wdbService.deleteBatchIds(Arrays.asList(ids));
		return Result.ok();
	}
	
}
