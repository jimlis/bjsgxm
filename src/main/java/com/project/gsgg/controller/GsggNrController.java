package com.project.gsggNr.controller;


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
import com.project.gsggNr.domain.GsggNrDO;
import com.project.gsggNr.service.GsggNrService;
import com.ifast.common.utils.Result;

/**
 * 
 * <pre>
 * 公司公告-内容
 * </pre>
 * <small> 2018-09-13 20:26:41 | lijun</small>
 */
@Controller
@RequestMapping("/project/gsggNr")
public class GsggNrController extends AdminBaseController {
	@Autowired
	private GsggNrService gsggNrService;
	
	@GetMapping()
	@RequiresPermissions("project:gsggNr:gsggNr")
	String GsggNr(){
	    return "project/gsggNr/gsggNr";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("project:gsggNr:gsggNr")
	public Result<Page<GsggNrDO>> list(GsggNrDO gsggNrDTO){
        Wrapper<GsggNrDO> wrapper = new EntityWrapper<GsggNrDO>(gsggNrDTO);
        Page<GsggNrDO> page = gsggNrService.selectPage(getPage(GsggNrDO.class), wrapper);
        return Result.ok(page);
	}
	
	@GetMapping("/add")
	@RequiresPermissions("project:gsggNr:add")
	String add(){
	    return "project/gsggNr/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("project:gsggNr:edit")
	String edit(@PathVariable("id") Long id,Model model){
		GsggNrDO gsggNr = gsggNrService.selectById(id);
		model.addAttribute("gsggNr", gsggNr);
	    return "project/gsggNr/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("project:gsggNr:add")
	public Result<String> save( GsggNrDO gsggNr){
		gsggNrService.insert(gsggNr);
        return Result.ok();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("project:gsggNr:edit")
	public Result<String>  update( GsggNrDO gsggNr){
		gsggNrService.updateById(gsggNr);
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("project:gsggNr:remove")
	public Result<String>  remove( Long id){
		gsggNrService.deleteById(id);
        return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("project:gsggNr:batchRemove")
	public Result<String>  remove(@RequestParam("ids[]") Long[] ids){
		gsggNrService.deleteBatchIds(Arrays.asList(ids));
		return Result.ok();
	}
	
}
