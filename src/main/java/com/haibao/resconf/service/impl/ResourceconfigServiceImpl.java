package com.haibao.resconf.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.cglib.CglibUtil;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.haibao.resconf.common.Constants;
import com.haibao.resconf.common.cache.ICacheService;
import com.haibao.resconf.common.domain.ResResult;
import com.haibao.resconf.common.enums.CacheMetaEnum;
import com.haibao.resconf.common.utils.GsonUtils;
import com.haibao.resconf.domain.model.Resourceconfig;
import com.haibao.resconf.domain.model.Resourceentryrecord;
import com.haibao.resconf.domain.model.Resourceniche;
import com.haibao.resconf.domain.query.ResourceconfigQuery;
import com.haibao.resconf.domain.query.ResourceentryrecordQuery;
import com.haibao.resconf.mapper.ResourceMapper;
import com.haibao.resconf.mapper.ResourceconfigMapper;
import com.haibao.resconf.service.IResourceconfigService;
import com.haibao.resconf.service.IResourceentryrecordService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Service业务层处理
 *
 * @author wuque
 * @date 2021-09-03
 */
@Service
public class ResourceconfigServiceImpl implements IResourceconfigService {
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private ResourceconfigMapper resourceconfigMapper;
    @Autowired
    private IResourceentryrecordService resourceentryrecordService;
    @Autowired
    private ICacheService cacheService;

    /**
     * 查询
     *
     * @param id 主键
     * @return
     */
    @Override
    public Resourceconfig selectResourceconfigById(Long id) {
        return resourceconfigMapper.selectResourceconfigById(id);
    }

    /**
     * 查询列表
     *
     * @param resourceconfigQuery
     * @return
     */
    @Override
    public List<Resourceconfig> selectResourceconfigList(ResourceconfigQuery resourceconfigQuery) {

        Resourceconfig resourceconfig = CglibUtil.copy(resourceconfigQuery, Resourceconfig.class);

        if (null == resourceconfig.getIsDeleted()) {
            resourceconfig.setIsDeleted(Constants.IS_DELETED_NO);
        }

        return resourceconfigMapper.selectResourceconfigList(resourceconfig);
    }

    /**
     * 新增
     *
     * @param resourceconfig
     * @return 结果
     */
    @Override
    public ResResult insertResourceconfig(Resourceconfig resourceconfig) {

        //校验 字段 是否 已存在
        Resourceconfig resourceconfig_ = new Resourceconfig();
        resourceconfig_.setResourceId(resourceconfig.getResourceId());
        resourceconfig_.setMetaKey(resourceconfig.getMetaKey());
        resourceconfig_.setIsDeleted(Constants.IS_DELETED_NO);
        List<Resourceconfig> resourceconfigs = resourceconfigMapper.selectResourceconfigList(resourceconfig_);
        if(resourceconfigs.size() > 0){
            return ResResult.error("This field already exists and cannot be added repeatedly!");
        }

        resourceconfig.setSort(null == resourceconfig.getSort() ? 0 : resourceconfig.getSort());
        resourceconfig.setRequired(StrUtil.isEmpty(resourceconfig.getRequired()) ? "0" : resourceconfig.getRequired());
        resourceconfig.setEditable(StrUtil.isEmpty(resourceconfig.getEditable()) ? "0" : resourceconfig.getEditable());
        resourceconfig.setIsDeleted(Constants.IS_DELETED_NO);
        resourceconfig.setCreated((int) (DateUtil.current() / 1000));
        resourceconfig.setUpdated((int) (DateUtil.current() / 1000));
        resourceconfig.setCreater("1");
        resourceconfig.setUpdater("1");
        resourceconfigMapper.insertResourceconfig(resourceconfig);

        Resourceniche resourceniche = resourceMapper.selectResourceById(resourceconfig.getResourceId());
        cacheService.scanAndDelete(CacheMetaEnum.CACHE_RESOURCE, resourceniche.getCachePattern());

        return ResResult.success(resourceconfig.getId());

    }

    /**
     * 修改
     *  字段类型不可更改
     * @param resourceconfig
     * @return 结果
     */
    @Transactional
    @Override
    public ResResult updateResourceconfig(Resourceconfig resourceconfig) {
        if (!checkOnline(String.valueOf(resourceconfig.getResourceId()))) {
            return ResResult.error("There are already online materials and cannot be updated!");
        }

        Resourceconfig resourceconfigDB = resourceconfigMapper.selectResourceconfigById(resourceconfig.getId());
        //校验 字段 是否 已存在
       if(StrUtil.isNotEmpty(resourceconfig.getMetaKey())){
           Resourceconfig resourceconfigCheck = new Resourceconfig();
           resourceconfigCheck.setResourceId(resourceconfigDB.getResourceId());
           resourceconfigCheck.setMetaKey(resourceconfig.getMetaKey());
           resourceconfigCheck.setIsDeleted(Constants.IS_DELETED_NO);
           List<Resourceconfig> resourceconfigs = resourceconfigMapper.selectResourceconfigList(resourceconfigCheck);
           long count = resourceconfigs.stream().filter(resourceconfig_ -> {
               return  !resourceconfig_.getId().equals(resourceconfig.getId());
           }).count();
           if(count > 0){
               return ResResult.error("This field already exists and cannot be added repeatedly!");
           }
       }

        resourceconfig.setUpdated((int) (DateUtil.current() / 1000));
        resourceconfig.setUpdater("1");
        int num = resourceconfigMapper.updateResourceconfig(resourceconfig);

        Resourceniche resourceniche = resourceMapper.selectResourceById(resourceconfigDB.getResourceId());
        cacheService.scanAndDelete(CacheMetaEnum.CACHE_RESOURCE, resourceniche.getCachePattern());

        return ResResult.success(num);
    }

    /**
     * 校验是否存在 该资源位下的上线素材
     *
     * @param resourceIds
     * @return
     */
    private boolean checkOnline(String resourceIds) {
        Long count = resourceentryrecordService.getCountByResourceIds(resourceIds, Constants.STATUS_ONLINE);
        if (count > 0) {
            return false;
        }
        return true;
    }

    /**
     * 批量删除
     *
     * @param ids 需要删除的主键
     * @return 结果
     */
    @Transactional
    @Override
    public ResResult deleteResourceconfigByIds(String ids) {
        //校验 是否存在 上线中的素材
        List<Resourceconfig> resourceconfigList = Arrays.stream(Convert.toStrArray(ids)).distinct()
                .parallel().map(key -> {
                    return resourceconfigMapper.selectResourceconfigById(Long.parseLong(key));
                }).collect(Collectors.toList());

        Set<Long> resourceIds = resourceconfigList.stream().map(resourceconfig -> {
            return resourceconfig.getResourceId();
        }).collect(Collectors.toSet());

        if (!checkOnline(StringUtils.join(resourceIds, ","))) {
            return ResResult.error("There are already online materials and cannot be deleted!");
        }

        //分组
        Map<Long, List<Resourceconfig>> groupByResourceconfigMap = resourceconfigList.stream().collect(Collectors.groupingBy(Resourceconfig::getResourceId));

        //剔除 素材对应字段值
        resourceIds.parallelStream().forEach(resourceId -> {
            ResourceentryrecordQuery resourceentryrecordQuery = new ResourceentryrecordQuery();
            resourceentryrecordQuery.setResourceId(resourceId);
            List<Resourceentryrecord> resourceentryrecords = resourceentryrecordService
                    .selectResourceentryrecordList(resourceentryrecordQuery);

            if(CollUtil.isNotEmpty(resourceentryrecords)){
                resourceentryrecords.forEach(resourceentryrecord -> {
                    if(ObjectUtil.isEmpty(resourceentryrecord)){
                        return;
                    }
                    Map fieldMap = resourceentryrecord.getMetaJsonValue();
                    if(null == fieldMap || fieldMap.size() < 1){
                        fieldMap = Maps.newHashMap();
                    }
                    List<Resourceconfig> resourceconfigs = groupByResourceconfigMap.get(resourceentryrecord.getResourceId());
                    if(CollUtil.isEmpty(resourceconfigs)){
                        resourceconfigs = Lists.newArrayList();
                    }
                    List<String> metaKeys = resourceconfigs.stream().map(resourceconfig -> {
                        return resourceconfig.getMetaKey();
                    }).collect(Collectors.toList());

                    fieldMap.keySet().removeAll(new HashSet<String>(metaKeys));
                    resourceentryrecord.setMetaValue(GsonUtils.gsonString(fieldMap));
                    resourceentryrecordService.updateResourceentryrecord(resourceentryrecord);
                });
            }

        });

        int num = resourceconfigMapper.deleteResourceconfigByIds(Convert.toStrArray(ids));

        resourceIds.parallelStream().forEach(resourceId ->{
            Resourceniche resourceniche = resourceMapper.selectResourceById(resourceId);
            cacheService.scanAndDelete(CacheMetaEnum.CACHE_RESOURCE, resourceniche.getCachePattern());
        });

        return ResResult.success(num);
    }

    /**
     * 删除信息
     *
     * @param id 主键
     * @return 结果
     */
    @Transactional
    @Override
    public ResResult deleteResourceconfigById(Long id) {
        Resourceconfig resourceconfig = selectResourceconfigById(id);

        if (!checkOnline(String.valueOf(resourceconfig.getResourceId()))) {
            return ResResult.error("There are already online materials and cannot be deleted!");
        }

        int num = resourceconfigMapper.deleteResourceconfigById(id);

        Resourceniche resourceniche = resourceMapper.selectResourceById(resourceconfig.getResourceId());
        cacheService.scanAndDelete(CacheMetaEnum.CACHE_RESOURCE, resourceniche.getCachePattern());

        return ResResult.success(num);
    }
}
