package com.haibao.resconf.domain.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wuque
 * @date: 2021/9/6 10:39
 * @description:
 */
public class ResourcenicheVO implements Serializable {

    /** 编码 */
    private String code;

    /** 名字 */
    private String name;

    /** 平台code标识 */
    private String platformCode;

    /** 平台名称 */
    private String platformName;

    /** 分类标识 */
    private String classify;

    public ResourcenicheVO() {
    }

    private List<ResourceconfigVO> configs;

    private List<ResourceentryrecordVO> records;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatformCode() {
        return platformCode;
    }

    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public List<ResourceconfigVO> getConfigs() {
        return configs;
    }

    public void setConfigs(List<ResourceconfigVO> configs) {
        this.configs = configs;
    }

    public List<ResourceentryrecordVO> getRecords() {
        return records;
    }

    public void setRecords(List<ResourceentryrecordVO> records) {
        this.records = records;
    }
}
