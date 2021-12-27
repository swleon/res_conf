package com.haibao.resconf.domain.model;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Maps;
import com.haibao.resconf.common.domain.BaseModel;
import com.haibao.resconf.common.utils.GsonUtils;
import com.haibao.resconf.common.validation.SaveGroup;
import com.haibao.resconf.common.validation.UpdateGroup;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Map;

/**
 * @author: wuque
 * @date: 2021/9/3 16:05
 * @description:
 */
public class Resourceentryrecord extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(groups = {UpdateGroup.class, SaveGroup.class}, message = "The resource niche id can not be empty")
    private Long resourceId;

    /**
     * 素材状态 0 测试 1上线
     */
    private String status;

    /**
     * 开始时间
     */
    @NotNull(groups = {SaveGroup.class}, message = "The start time can not be empty")
    private String startTime;

    /**
     * 结束时间
     */
    @NotNull(groups = {SaveGroup.class}, message = "The end time can not be empty")
    private String endTime;

    /**
     * 元字段名称
     */
    private String metaName;

    /**
     * 投放内容
     */
    private String metaValue;
    @NotNull(groups = {SaveGroup.class}, message = "The kv json value can not be empty")
    private Map metaJsonValue;

    /**
     * 素材顺序
     */
    private Long sort;

    /**
     * 扩展属性
     */
    private String extend;

    /**
     * 完全匹配字段
     */
    private String term;

    /**
     * 策略
     */
    private String strategy;

    /**
     * 策略值
     */
    private String strategyValue;

    /**
     * 分类
     */
    private Integer type;

    @Size(max=64,groups = {SaveGroup.class, UpdateGroup.class}, message = "The maximum length of the siteCode is 64")
    private String siteCode;
    @Size(max=255,groups = {SaveGroup.class, UpdateGroup.class}, message = "The maximum length of the siteName is 255")
    private String siteName;

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
    /**
     * 描述
     */
    @Size(max=1024,groups = {SaveGroup.class, UpdateGroup.class}, message = "The maximum length of the describe is 1024")
    private String describer;


    /**
     * 有效期标识 自定义
     */
    private Integer termOfValidity;

    public Resourceentryrecord() {
    }

    public String getDescriber() {
        return describer;
    }

    public void setDescriber(String describer) {
        this.describer = describer;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
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


    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setMetaValue(String metaValue) {
        this.metaValue = metaValue;
    }

    public String getMetaValue() {
        return metaValue;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Long getSort() {
        return sort;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getExtend() {
        return extend;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTerm() {
        return term;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategyValue(String strategyValue) {
        this.strategyValue = strategyValue;
    }

    public String getStrategyValue() {
        return strategyValue;
    }

    public String getMetaName() {
        return metaName;
    }

    public void setMetaName(String metaName) {
        this.metaName = metaName;
    }

    public Integer getTermOfValidity() {
        return termOfValidity;
    }

    public void setTermOfValidity(Integer termOfValidity) {
        this.termOfValidity = termOfValidity;
    }

    public Map getMetaJsonValue() {
        if(null == metaJsonValue || metaJsonValue.size() < 1){
            if(StrUtil.isNotEmpty(metaValue)){
                return GsonUtils.gsonToMaps(metaValue);
            }
        }
        return metaJsonValue;
    }

    public void setMetaJsonValue(Map metaJsonValue) {
        if(null != metaJsonValue && metaJsonValue.size() > 0){
            this.metaJsonValue = metaJsonValue;
        }else{
            if(StrUtil.isNotEmpty(metaValue)){
                this.metaJsonValue = GsonUtils.gsonToMaps(metaValue);
            }else{
                metaJsonValue = Maps.newHashMap();
            }
        }
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("resourceId", getResourceId())
                .append("status", getStatus())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("metaValue", getMetaValue())
                .append("sort", getSort())
                .append("extend", getExtend())
                .append("term", getTerm())
                .append("strategy", getStrategy())
                .append("strategyValue", getStrategyValue())
                .append("created", getCreated())
                .append("updated", getUpdated())
                .append("isDeleted", getIsDeleted())
                .append("siteCode", getSiteCode())
                .toString();
    }

}
