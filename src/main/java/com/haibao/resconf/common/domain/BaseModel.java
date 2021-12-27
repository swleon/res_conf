package com.haibao.resconf.common.domain;

import com.haibao.resconf.common.validation.UpdateGroup;

import javax.validation.constraints.NotNull;

/**
 * 基础model属性
 *
 * @author wuque
 * @since 2021.08.26
 */
public class BaseModel {

    @NotNull(groups = UpdateGroup.class, message = "The id can not be null")
    protected Long id;
    protected Integer created;
    protected Integer updated;
    protected Integer isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getUpdated() {
        return updated;
    }

    public void setUpdated(Integer updated) {
        this.updated = updated;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
