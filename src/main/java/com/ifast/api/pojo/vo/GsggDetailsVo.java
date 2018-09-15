package com.ifast.api.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ifast.oss.domain.FileDO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *公司公告详情
 */
public class GsggDetailsVo implements Serializable{
    /**
     * 公告公告id
     */
    private Long id;
    /**
     * 公告名称
     */
    private String chrbt;
    /**
     * 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date dtmfbsj;
    /**
     * 登记人名称
     */
    private String chrdjrmc;
    /**
     * 登记部门名称
     */
    private String chrdjrbmmc;
    /**
     * 公告内容
     */
    private String chrggnr;
    /**
     *文件集合
     */
    private List<FileDO> fileList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChrbt() {
        return chrbt;
    }

    public void setChrbt(String chrbt) {
        this.chrbt = chrbt;
    }

    public Date getDtmfbsj() {
        return dtmfbsj;
    }

    public void setDtmfbsj(Date dtmfbsj) {
        this.dtmfbsj = dtmfbsj;
    }

    public String getChrdjrmc() {
        return chrdjrmc;
    }

    public void setChrdjrmc(String chrdjrmc) {
        this.chrdjrmc = chrdjrmc;
    }

    public String getChrdjrbmmc() {
        return chrdjrbmmc;
    }

    public void setChrdjrbmmc(String chrdjrbmmc) {
        this.chrdjrbmmc = chrdjrbmmc;
    }

    public String getChrggnr() {
        return chrggnr;
    }

    public void setChrggnr(String chrggnr) {
        this.chrggnr = chrggnr;
    }

    public List<FileDO> getFileList() {
        return fileList;
    }

    public void setFileList(List<FileDO> fileList) {
        this.fileList = fileList;
    }
}
