package com.haibao.resconf.domain.query;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.haibao.resconf.common.page.PageDomain;
import com.haibao.resconf.common.utils.GsonUtils;

import java.io.Serializable;

/**
 * @author: wuque
 * @date: 2021/9/6 10:39
 * @description:
 */
public class ResourcenicheQuery extends PageDomain implements Serializable {

    /** 编码 */
    private String code;

    /** 名字 */
    private String name;

    /** 平台code标识 */
    private String platformCode;

    /** 平台名称 */
    private String platformName;

    /** 站点code标识 */
    private String siteCode;

    /** 站点名称 */
    private String siteName;

    /** 分类标识 */
    private String classify;

    /** 策略配置 */
    private String strategy;

    /** 扩展配置 */
    private String metaValue;

    /**
     * 创建者
     */
    private String creater;
    /**
     * 更新者
     */
    private String updater;
    /**
     * 部门
     */
    private String depart;

    private Integer isDeleted;

    /**
     * 仅搜索自己相关
     * 0否 1是
     */
    private Integer searchYourself;



    public String getCacheKey() {
        String classify = StrUtil.isEmpty(getClassify())?"0":getClassify().replaceAll("#","-");
        return getPlatformCode()+":"+classify+":"+SecureUtil.md5(GsonUtils.gsonString(this));
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public ResourcenicheQuery() {
    }

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

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public String getMetaValue() {
        return metaValue;
    }

    public void setMetaValue(String metaValue) {
        this.metaValue = metaValue;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public Integer getSearchYourself() {
        return searchYourself;
    }

    public void setSearchYourself(Integer searchYourself) {
        this.searchYourself = searchYourself;
    }
}
