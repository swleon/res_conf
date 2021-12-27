package com.haibao.resconf.domain.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author: wuque
 * @date: 2021/9/3 15:51
 * @description:
 */
public class ResourceconfigVO implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 提示文案
     */
    private String metaTips;

    /**
     * 默认值
     */
    private String defaultValue;

    public ResourceconfigVO() {
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


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("metaKey", getMetaKey())
                .append("metaName", getMetaName())
                .append("dataType", getDataType())
                .append("metaTips", getMetaTips())
                .append("defaultValue", getDefaultValue())
                .toString();
    }
}
