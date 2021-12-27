package com.haibao.resconf.domain.vo;

import java.io.Serializable;
import java.util.Map;

/**
 * @author: wuque
 * @date: 2021/9/3 16:05
 * @description:
 */
public class ResourceentryrecordVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 投放内容
     */
    private Long id;
    private Long resourceId;
    private String metaValue;
    private Map metaJsonValue;
    private String siteCode;
    private String siteName;

    private String acm;

    public ResourceentryrecordVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMetaValue() {
        return metaValue;
    }

    public void setMetaValue(String metaValue) {
        this.metaValue = metaValue;
    }

    public Map getMetaJsonValue() {
        return metaJsonValue;
    }

    public void setMetaJsonValue(Map metaJsonValue) {
        this.metaJsonValue = metaJsonValue;
    }

    public String getAcm() {
        return acm;
    }

    public void setAcm(String acm) {
        this.acm = acm;
    }
}
