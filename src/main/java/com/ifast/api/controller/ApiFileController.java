package com.ifast.api.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.fasterxml.jackson.annotation.JsonView;
import com.ifast.common.annotation.Log;
import com.ifast.common.base.ApiBaseController;
import com.ifast.common.utils.Result;
import com.ifast.common.utils.View;
import com.ifast.oss.domain.FileDO;
import com.ifast.oss.service.FileService;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <pre>
 * 文件Api控制器
 * </pre>
 */
@RestController
@RequestMapping("/api/file/")
public class ApiFileController  extends ApiBaseController {
    @Autowired
    private FileService fileService;


    @Log("查询文档附件列表")
    @ResponseBody
    @PostMapping("/wdlist")
    @JsonView(View.WdbApp.class)
    @ApiOperation(value="根据文件类型获取文档附件列表",httpMethod="POST")
    @ApiImplicitParams(@ApiImplicitParam(name="type",paramType="string",required=false,value = "文件类型"))
    @ApiResponses({@ApiResponse(code=0,message="操作成功",response=List.class),
            @ApiResponse(code=1,message="操作失败",response=List.class)})
    @RequiresAuthentication
    public Result<List<FileDO>> list(FileDO fileDO) {
        // 查询列表数据
        Page<FileDO> page = fileService.selectPage(getPage(FileDO.class), fileService.convertToEntityWrapper("busType", "bj_wdb", "type", fileDO.getType()));
        return Result.ok(page.getRecords());
    }
}