package com.haibao.resconf.common.cache;

import com.haibao.resconf.common.enums.CacheMetaEnum;

public interface ICacheService {


    void scanAndDelete(CacheMetaEnum cacheResource, String cachePattern);

    void scanAndDeletePipelined(String buildKey);

    boolean exists(CacheMetaEnum cacheResource, String cacheKey);

    String get(CacheMetaEnum cacheResource, String cacheKey);

    void set(CacheMetaEnum cacheResource, String cacheKey, String gsonString);
}
