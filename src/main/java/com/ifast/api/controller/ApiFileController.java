package com.ifast.api.controller;

import com.ifast.common.base.ApiBaseController;
import com.ifast.common.utils.Result;
import com.ifast.oss.service.FileService;
import com.ifast.sys.service.DeptService;
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
 * 文件Api控制器
 * </pre>
 */
@RestController
@RequestMapping("/api/file/")
public class ApiFileController  extends ApiBaseController {
    @Autowired
    private FileService fileService;


}
