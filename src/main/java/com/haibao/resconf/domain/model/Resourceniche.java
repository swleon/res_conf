package com.haibao.resconf.domain.model;

import cn.hutool.core.util.StrUtil;
import com.haibao.resconf.common.domain.BaseModel;
import com.haibao.resconf.common.validation.SaveGroup;
import com.haibao.resconf.common.validation.UpdateGroup;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author: wuque
 * @date: 2021/9/3 15:54
 * @description:
 */
@AllArgsConstructor
public class Resourceniche extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 编码 */
    private String code;

    /** 名字 */
    @NotNull(groups = {SaveGroup.class}, message = "The name can not be empty")
    @Size(max=255,groups = {SaveGroup.class, UpdateGroup.class}, message = "The maximum length of the name is 255")
    private String name;

    /** 站点code标识 */
    @Size(max=64,groups = {SaveGroup.class, UpdateGroup.class}, message = "The maximum length of the platform code is 64")
    private String platformCode;

    /** 站点名称 */
    @Size(max=120,groups = {SaveGroup.class, UpdateGroup.class}, message = "The maximum length of the platform name is 120")
    private String platformName;

    /** 分类标识 */
    @NotNull(groups = {SaveGroup.class}, message = "The classify can not be empty")
    @Size(max=255,groups = {SaveGroup.class, UpdateGroup.class}, message = "The maximum length of the classify is 255")
    private String classify;

    /** 模板编码 */
    private String templateCode;

    /** 描述 */
    @Size(max=512,groups = {SaveGroup.class, UpdateGroup.class}, message = "The maximum length of the classify is 512")
    private String describe;

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

    private Integer recordTotal;
    private Integer recordOnlineTotal;

    public String getCachePattern() {
        String classify = StrUtil.isEmpty(getClassify())?"0":getClassify().replaceAll("#","-");
        return getPlatformCode()+":"+classify;
    }

    public Resourceniche() {
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

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
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

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setStrategy(String strategy)
    {
        this.strategy = strategy;
    }

    public String getStrategy()
    {
        return strategy;
    }
    public void setMetaValue(String metaValue)
    {
        this.metaValue = metaValue;
    }

    public String getMetaValue()
    {
        return metaValue;
    }

    public Integer getRecordTotal() {
        return recordTotal;
    }

    public void setRecordTotal(Integer recordTotal) {
        this.recordTotal = recordTotal;
    }

    public Integer getRecordOnlineTotal() {
        return recordOnlineTotal;
    }

    public void setRecordOnlineTotal(Integer recordOnlineTotal) {
        this.recordOnlineTotal = recordOnlineTotal;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("code", getCode())
                .append("name", getName())
                .append("platformCode", getPlatformCode())
                .append("platformName", getPlatformName())
                .append("classify", getClassify())
                .append("templateCode", getTemplateCode())
                .append("describe", getDescribe())
                .append("strategy", getStrategy())
                .append("metaValue", getMetaValue())
                .append("created", getCreated())
                .append("updated", getUpdated())
                .append("isDeleted", getIsDeleted())
                .toString();
    }

}
