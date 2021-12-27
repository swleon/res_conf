package com.haibao.resconf.domain.query;

import com.haibao.resconf.common.page.PageDomain;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author: wuque
 * @date: 2021/9/3 16:05
 * @description:
 */
public class ResourceentryrecordQuery extends PageDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "resourceId cannot be empty")
    private Long resourceId;

    /**
     * 素材状态 0 测试 1上线
     */
    private String status;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 元字段名称
     */
    private String metaName;

    /**
     * 投放内容
     */
    private String metaValue;

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

    private String siteCode;
    private String siteName;

    /**
     * 有效期标识 自定义
     */
    private Integer termOfValidity;

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
    private String describer;

    private Integer isDeleted;

    public ResourceentryrecordQuery() {
    }

    public String getDescriber() {
        return describer;
    }

    public void setDescriber(String describer) {
        this.describer = describer;
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

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
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
                .append("isDeleted", getIsDeleted())
                .toString();
    }
}
