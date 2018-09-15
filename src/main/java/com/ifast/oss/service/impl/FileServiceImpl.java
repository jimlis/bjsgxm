package com.ifast.oss.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import com.ifast.common.exception.IFastException;
import com.ifast.common.utils.FileUtil;
import com.ifast.common.utils.ShiroUtils;
import com.ifast.sys.domain.UserDO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Service;

import com.ifast.common.base.CoreServiceImpl;
import com.ifast.common.config.IFastConfig;
import com.ifast.common.utils.DateUtils;
import com.ifast.common.utils.FileType;
import com.ifast.oss.dao.FileDao;
import com.ifast.oss.domain.FileDO;
import com.ifast.oss.sdk.QiNiuOSSService;
import com.ifast.oss.service.FileService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <pre>
 * </pre>
 * 
 * <small> 2018年3月23日 | Aron</small>
 */
@Service
public class FileServiceImpl extends CoreServiceImpl<FileDao, FileDO> implements FileService {

    @Autowired
    private IFastConfig ifastConfig;
    @Autowired
    private QiNiuOSSService qiNiuOSS;

    @Autowired
    private ConfigurableEnvironment environment;

    /**
     * <pre>
     * 上传文件到硬盘
     * </pre>、
     * @param file 文件对象
     * @return
     */
    @Override
    public FileDO uploadFile(MultipartFile file)  throws Exception{
        String uploadPath=environment.getProperty("uploadPath");
        if(StringUtils.isEmpty(uploadPath)) throw  new IFastException("请配置上传文件的路径（uploadPath）");
        LocalDate localDate=LocalDate.now();
        uploadPath=uploadPath+ File.separator+"wdb"+File.separator+localDate.getYear()+File.separator+
                localDate.getMonth().getValue();
        File folder=new File(uploadPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        Long currentTimeMillis=System.currentTimeMillis();
        String fileName=file.getOriginalFilename();
        String name=file.getName();
        String[] fileArr=fileName.split("\\.");
        String prefix=fileArr[0];
        String suffix=fileArr.length>=2?fileArr[1]:"";

        String newFileName=prefix+"_"+ UUID.randomUUID().toString().replace("-","")+"."+suffix;
        String url= File.separator+"wdb"+File.separator+localDate.getYear()+File.separator+
                localDate.getMonth().getValue()+File.separator+newFileName;
        File createfile=new File(uploadPath+File.separator+newFileName);
        if(!createfile.exists()){
            createfile.createNewFile();
        }
        file.transferTo(createfile);

        FileDO fileDO=new FileDO();
        UserDO userDO= ShiroUtils.getSysUser();
        fileDO.setBusType("bj_wdb");
        fileDO.setFileName(fileName);
        fileDO.setFileSize(file.getSize());
        fileDO.setCreateUserId(userDO.getId());
        fileDO.setCreateUserName(userDO.getName());
        fileDO.setCreateDeptId(userDO.getDeptId());
        fileDO.setCreateDeptName(userDO.getDeptName());
        fileDO.setCreateDate(new Date());
        fileDO.setUrl(url);
        insert(fileDO);
        return fileDO;
    }

    @Override
    public void downFile(Long id, HttpServletRequest request, HttpServletResponse response) {
        FileDO fileDO=selectById(id);
        if(fileDO!=null){
            String uploadPath=environment.getProperty("uploadPath");
            String url=fileDO.getUrl();
            String filePath=uploadPath+url;
            try (InputStream in = new FileInputStream(new File(filePath))) {
                FileUtil.writeFj(request,response,fileDO.getFileName(),in);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
