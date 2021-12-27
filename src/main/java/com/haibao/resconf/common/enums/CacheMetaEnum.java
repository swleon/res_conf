package com.haibao.resconf.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 缓存相关设置
 *
 * @author wuque
 * @since 2021.08.29
 */
@Getter
@AllArgsConstructor
public enum CacheMetaEnum {
    /**
     * 缓存key，过期时间，描述
     */
    CACHE_RESOURCE("resource_%s", 30 * 60, "资源位素材信息"),
    ;

    private final String format;
    private final int expire;
    private final String desc;

    public String buildKey(Object... param) {
        return String.format(format, param);
    }

    public static CacheMetaEnum getEnumByFormat(String format) {
        CacheMetaEnum[] values = values();
        for (CacheMetaEnum item : values) {
            if (item.getFormat().equals(format)) {
                return item;
            }
        }
        return null;
    }

}
