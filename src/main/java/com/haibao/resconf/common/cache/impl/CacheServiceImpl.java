package com.haibao.resconf.common.cache.impl;

import com.haibao.resconf.common.cache.ICacheService;
import com.haibao.resconf.common.enums.CacheMetaEnum;
import com.haibao.resconf.common.redis.RedisCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author wuque
 * @title: CacheServiceImpl
 * @projectName ShortUrl
 * @description: 缓存操作
 * @date 2021/12/259:59 下午
 */
@Service("cacheService")
@Slf4j
public class CacheServiceImpl implements ICacheService {

    @Resource
    RedisCache redisCache;

    @Override
    public void scanAndDelete(CacheMetaEnum cacheResource, String cachePattern) {
        redisCache.scanAndDelete(cacheResource.buildKey(cachePattern));
    }

    @Override
    public void scanAndDeletePipelined(String buildKey) {
        redisCache.scanAndDeletePipelined(buildKey);
    }

    @Override
    public boolean exists(CacheMetaEnum cacheResource, String cacheKey) {

        return redisCache.exists(cacheResource.buildKey(cacheKey));
    }

    @Override
    public String get(CacheMetaEnum cacheResource, String cacheKey) {

        return redisCache.getCacheObject(cacheResource.buildKey(cacheKey));
    }

    @Override
    public void set(CacheMetaEnum cacheResource, String cacheKey, String value) {
        redisCache.setCacheObject(cacheResource.buildKey(cacheKey),value,cacheResource.getExpire(), TimeUnit.MINUTES);
    }
}
