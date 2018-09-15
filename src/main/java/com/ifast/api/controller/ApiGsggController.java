package com.ifast.api.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ifast.api.pojo.vo.GsggDetailsVo;
import com.ifast.common.annotation.Log;
import com.ifast.common.base.ApiBaseController;
import com.ifast.common.utils.Result;
import com.ifast.oss.domain.FileDO;
import com.ifast.oss.service.FileService;
import com.ifast.sys.service.DeptService;
import com.project.gsgg.domain.GsggDO;
import com.project.gsgg.domain.GsggNrDO;
import com.project.gsgg.service.GsggNrService;
import com.project.gsgg.service.GsggService;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <pre>
 * 公司公告Api控制器
 * </pre>
 */
@RestController
@RequestMapping("/api/gsgg/")
public class ApiGsggController extends ApiBaseController {
    @Autowired
    private GsggService gsggService;
    @Autowired
    private GsggNrService gsggNrService;
    @Autowired
    private FileService fileService;

    @Log("获取公司公告列表")
    @PostMapping("list")
    @ApiOperation(value="获取公司公告列表",httpMethod="POST")
    @ApiResponses({@ApiResponse(code=0,message="操作成功",response=List.class),
    	@ApiResponse(code=1,message="操作失败",response=List.class)})
    @RequiresAuthentication
    public Result<List<GsggDO>> list() {
        // 查询列表数据
        Page<GsggDO> page = gsggService.selectPage(getPage(GsggDO.class), gsggService.convertToEntityWrapper("fcbz",1));
        return Result.ok(page.getRecords());
    }

    @Log("根据公告id获取公司公告详情信息")
    @PostMapping("details")
    @ApiOperation(value="根据公告id获取公司公告详情信息",httpMethod="POST")
    @ApiImplicitParams(@ApiImplicitParam(name="id",paramType="long",required=true,value = "公司公告id"))
    @ApiResponses({@ApiResponse(code=0,message="操作成功",response=List.class),
            @ApiResponse(code=1,message="操作失败",response=List.class)})
    @RequiresAuthentication
    public Result<GsggDetailsVo> details(Long id) {
        if(null==id){
            return  Result.fail();
        }
        return Result.ok(gsggService.getGsggDetailsById(id));
    }
}
