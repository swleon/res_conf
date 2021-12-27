package com.haibao.resconf.domain.query;

import com.haibao.resconf.common.page.PageDomain;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author: wuque
 * @date: 2021/9/3 15:51
 * @description:
 */
public class ResourceconfigQuery extends PageDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 关联资源位id
     */
    @NotNull(message = "resourceId cannot be empty")
    private Long resourceId;

    /**
     * 字段key
     */
    private String metaKey;

    /**
     * 字段名称
     */
    private String metaName;

    /**
     * 数据类型 0数字/1文案/2时间戳/3图片链接/4跳转链接/5视频链接/6单选/7多选/8下拉列表/9颜色
     */
    private Long dataType;

    /**
     * 一些额外字段元数据
     */
    private String metaValue;

    /**
     * 是否必需 0否 1是
     */
    private String required;

    /**
     * 是否可编辑  0否 1是
     */
    private String editable;

    /**
     * 展示顺序
     */
    private String sort;

    /**
     * 提示文案
     */
    private String metaTips;

    /**
     * 默认值
     */
    private String defaultValue;

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

    public ResourceconfigQuery() {
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setMetaKey(String metaKey) {
        this.metaKey = metaKey;
    }

    public String getMetaKey() {
        return metaKey;
    }

    public void setMetaName(String metaName) {
        this.metaName = metaName;
    }

    public String getMetaName() {
        return metaName;
    }

    public void setDataType(Long dataType) {
        this.dataType = dataType;
    }

    public Long getDataType() {
        return dataType;
    }

    public void setMetaValue(String metaValue) {
        this.metaValue = metaValue;
    }

    public String getMetaValue() {
        return metaValue;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String getRequired() {
        return required;
    }

    public void setEditable(String editable) {
        this.editable = editable;
    }

    public String getEditable() {
        return editable;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSort() {
        return sort;
    }

    public void setMetaTips(String metaTips) {
        this.metaTips = metaTips;
    }

    public String getMetaTips() {
        return metaTips;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDefaultValue() {
        return defaultValue;
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
                .append("metaKey", getMetaKey())
                .append("metaName", getMetaName())
                .append("dataType", getDataType())
                .append("metaValue", getMetaValue())
                .append("required", getRequired())
                .append("editable", getEditable())
                .append("sort", getSort())
                .append("metaTips", getMetaTips())
                .append("defaultValue", getDefaultValue())
                .append("isDeleted", getIsDeleted())
                .toString();
    }
}
