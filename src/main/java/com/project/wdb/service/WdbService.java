package com.project.wdb.service;

import com.project.wdb.domain.WdbDO;
import com.ifast.common.base.CoreService;

/**
 * 
 * <pre>
 * 
 * </pre>
 * <small> 2018-09-09 20:40:48 | lijun</small>
 */
public interface WdbService extends CoreService<WdbDO> {

    /**
     * 保存文档信息
     * @param wdbDO 文档对象
     * @param fileIds 相关联的附件ids 多个以逗号隔开
     */
    void  saveWdbxx(WdbDO wdbDO, String fileIds) throws  Exception;
}
