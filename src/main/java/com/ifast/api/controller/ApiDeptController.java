package com.ifast.api.controller;

import java.util.List;
import java.util.Map;

import com.ifast.common.base.ApiBaseController;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ifast.common.utils.Result;
import com.ifast.sys.service.DeptService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * <pre>
 * 部门Api控制器
 * </pre>
 */
@RestController
@RequestMapping("/api/dept/")
public class ApiDeptController extends ApiBaseController {
    @Autowired
    private DeptService deptService;

    @PostMapping("getNextDeptAndUser")
    @ApiOperation(value="根据部门id获取下一级部门、人员信息",httpMethod="POST")
    @ApiImplicitParams(@ApiImplicitParam(name="deptId",paramType="string",required=false,defaultValue="0",value = "部门id"))
    @ApiResponses({@ApiResponse(code=0,message="操作成功",response=List.class),
    	@ApiResponse(code=1,message="操作失败",response=List.class)})
    @RequiresAuthentication
    public Result<List<Map<String,Object>>> getNextDeptAndUser(@RequestParam(name="deptId",defaultValue="0")  Long deptId) {
        return Result.ok(deptService.getNextDeptAndUser(deptId));
    }
}
