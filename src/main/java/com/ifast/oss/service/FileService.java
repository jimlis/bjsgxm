package com.ifast.oss.service;

import com.ifast.common.base.CoreService;
import com.ifast.oss.domain.FileDO;
import org.springframework.web.multipart.MultipartFile;

/**
 * <pre>
 * 文件上传
 * </pre>
 * <small> 2018年4月6日 | Aron</small>
 */
public interface FileService extends CoreService<FileDO> {

    /**
     * <pre>
     * 上传文件到硬盘
     * </pre>、
     * @param file 文件对象
     * @return FileDO 文件对象
     */
    FileDO uploadFile (MultipartFile file) throws Exception;
}
