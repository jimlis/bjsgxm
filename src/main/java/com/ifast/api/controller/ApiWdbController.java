package com.ifast.api.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.fasterxml.jackson.annotation.JsonView;
import com.ifast.common.annotation.Log;
import com.ifast.common.base.ApiBaseController;
import com.ifast.common.utils.Result;
import com.ifast.common.utils.View;
import com.ifast.oss.service.FileService;
import com.project.wdb.domain.WdbDO;
import com.project.wdb.service.WdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * 文档Api控制器
 * </pre>
 */
@RestController
@RequestMapping("/api/wdb/")
public class ApiWdbController extends ApiBaseController{
    @Autowired
    private WdbService wdbService;

    @Log("查询文档列表")
    @ResponseBody
    @GetMapping("/list")
    @JsonView(View.WdbApp.class)
    public Result<Page<WdbDO>> list(WdbDO wdbDO) {
        // 查询列表数据
        Page<WdbDO> page = wdbService.selectPage(getPage(WdbDO.class), wdbService.convertToEntityWrapper("type", wdbDO.getType(), "intfcbz", 1));
        return Result.ok(page);
    }
    
}
