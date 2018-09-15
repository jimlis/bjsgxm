package com.ifast.api.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.fasterxml.jackson.annotation.JsonView;
import com.ifast.common.annotation.Log;
import com.ifast.common.base.ApiBaseController;
import com.ifast.common.utils.Result;
import com.ifast.common.utils.View;
import com.ifast.oss.domain.FileDO;
import com.ifast.oss.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/wdlist")
    @JsonView(View.WdbApp.class)
    public Result<Page<FileDO>> list(FileDO fileDO) {
        // 查询列表数据
        Page<FileDO> page = fileService.selectPage(getPage(FileDO.class), fileService.convertToEntityWrapper("busType", "bj_wdb", "type", fileDO.getType()));
        return Result.ok(page);
    }
}