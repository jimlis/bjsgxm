package com.project.gsgg.controller;


import java.util.Arrays;
import java.util.Objects;

import com.project.gsgg.domain.GsggNrDO;
import com.project.gsgg.service.GsggNrService;
import org.apache.commons.lang3.StringUtils;
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
import com.project.gsgg.domain.GsggDO;
import com.project.gsgg.service.GsggService;
import com.ifast.common.utils.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * <pre>
 * 公司公告
 * </pre>
 * <small> 2018-09-13 20:25:05 | lijun</small>
 */
@Controller
@RequestMapping("/project/gsgg")
public class GsggController extends AdminBaseController {
	@Autowired
	private GsggService gsggService;

	@Autowired
	private GsggNrService gsggNrService;
	
	@GetMapping()
	@RequiresPermissions("project:gsgg:gsgg")
	String Gsgg(){
	    return "project/gsgg/gsgg";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("project:gsgg:gsgg")
	public Result<Page<GsggDO>> list(GsggDO gsggDTO){
        Wrapper<GsggDO> wrapper = new EntityWrapper<GsggDO>().eq(StringUtils.isNotEmpty(gsggDTO.getChrlx()),"chrlx",gsggDTO.getChrlx()).
				like(StringUtils.isNotEmpty(gsggDTO.getChrbt()),"chrbt",gsggDTO.getChrbt()).eq("fcbz","1");
        Page<GsggDO> page = gsggService.selectPage(getPage(GsggDO.class), wrapper);
        return Result.ok(page);
	}
	
	@GetMapping("/add")
	@RequiresPermissions("project:gsgg:add")
	String add(){
	    return "project/gsgg/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("project:gsgg:edit")
	String edit(@PathVariable("id") Long id,Model model){
		GsggDO gsgg = gsggService.selectById(id);
		model.addAttribute("gsgg", gsgg);

		GsggNrDO gsggNrDO=new GsggNrDO();
		gsggNrDO.setIntggid(id);
		gsggNrDO.setFcbz(1);
		Wrapper<GsggNrDO> wrapper = new EntityWrapper<GsggNrDO>(gsggNrDO);
		gsggNrDO = gsggNrService.selectOne(wrapper);
		model.addAttribute("gsggnr", gsggNrDO);
	    return "project/gsgg/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("project:gsgg:add")
	public Result<String> save(HttpServletRequest request,GsggDO gsgg){
		String fileIds= Objects.toString(request.getParameter("fileIds"));
		String chrggnr= Objects.toString(request.getParameter("chrggnr"));
		try {
			gsggService.saveGsggxx(gsgg,chrggnr,fileIds);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.fail();
		}
		return Result.ok();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("project:gsgg:edit")
	public Result<String>  update( GsggDO gsgg){
		gsggService.updateById(gsgg);
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("project:gsgg:remove")
	public Result<String>  remove( Long id){
		gsggService.deleteById(id);
        return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("project:gsgg:batchRemove")
	public Result<String>  remove(@RequestParam("ids[]") Long[] ids){
		gsggService.deleteBatchIds(Arrays.asList(ids));
		return Result.ok();
	}
	
}
