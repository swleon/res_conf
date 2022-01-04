package com.haibao.resconf.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.cglib.CglibUtil;
import com.haibao.resconf.common.Constants;
import com.haibao.resconf.common.cache.ICacheService;
import com.haibao.resconf.common.domain.ResResult;
import com.haibao.resconf.common.enums.CacheMetaEnum;
import com.haibao.resconf.common.enums.ResResultCodeEnum;
import com.haibao.resconf.common.utils.GsonUtils;
import com.haibao.resconf.domain.model.Resourceconfig;
import com.haibao.resconf.domain.model.Resourceentryrecord;
import com.haibao.resconf.domain.model.Resourceniche;
import com.haibao.resconf.domain.query.ResourceconfigQuery;
import com.haibao.resconf.domain.query.ResourceentryrecordQuery;
import com.haibao.resconf.domain.query.ResourcenicheQuery;
import com.haibao.resconf.domain.vo.ResourceconfigVO;
import com.haibao.resconf.domain.vo.ResourceentryrecordVO;
import com.haibao.resconf.domain.vo.ResourcenicheVO;
import com.haibao.resconf.mapper.ResourceMapper;
import com.haibao.resconf.mapper.ResourceconfigMapper;
import com.haibao.resconf.mapper.ResourceentryrecordMapper;
import com.haibao.resconf.service.IResourceService;
import com.haibao.resconf.service.IResourceconfigService;
import com.haibao.resconf.service.IResourceentryrecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service业务层处理
 *
 * @author wuque
 * @date 2021-09-03
 */
@Service
public class ResourceServiceImpl implements IResourceService {
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private ResourceentryrecordMapper resourceentryrecordMapper;
    @Autowired
    private ResourceconfigMapper resourceconfigMapper;
    @Autowired
    private IResourceentryrecordService resourceentryrecordService;
    @Autowired
    private IResourceconfigService resourceconfigService;
    @Autowired
    private ICacheService cacheService;

    /**
     * 查询
     *
     * @param id 主键
     * @return
     */
    @Override
    public Resourceniche selectResourceById(Long id) {

        return resourceMapper.selectResourceById(id);
    }

    /**
     * 查询列表
     *
     * @param resource
     * @return
     */
    @Override
    public List<Resourceniche> selectResourceList(Resourceniche resource) {
        if(ObjectUtil.isEmpty(resource.getIsDeleted())){
            resource.setIsDeleted(Constants.IS_DELETED_NO);
        }
        return resourceMapper.selectResourceList(resource);
    }

    /**
     * 新增
     *
     * @param resource
     * @return 结果
     */
    @Transactional
    @Override
    public ResResult insertResource(Resourceniche resource) {

        //校验 同一个平台下的 classify 不能重复
        Resourceniche resource_ = new Resourceniche();
        resource_.setPlatformCode(resource.getPlatformCode());
        resource_.setIsDeleted(Constants.IS_DELETED_NO);
        resource_.setClassify(resource.getClassify());
        List<Resourceniche> resourceniches = resourceMapper.selectResourceList(resource_);
        if (resourceniches.size() > 0) {
            String msg = "";
            if(StrUtil.isNotEmpty(resourceniches.get(0).getPlatformName())){
                msg = "Under platform " + resourceniches.get(0).getPlatformName()+",";
            }
            msg += " The same classify exists and cannot be added";
            return ResResult.error(msg);
        }

        resource.setCode(UUID.fastUUID().toString(true));
        resource.setIsDeleted(Constants.IS_DELETED_NO);
        resource.setCreated((int) (DateUtil.current() / 1000));
        resource.setUpdated((int) (DateUtil.current() / 1000));
        resource.setCreater("1");
        resource.setUpdater("1");
        resourceMapper.insertResource(resource);

        return ResResult.success(resource.getId());
    }

    /**
     * 修改
     *
     * @param resourceniche
     * @return 结果
     */
    @Transactional
    @Override
    public ResResult updateResource(Resourceniche resourceniche) {
        //校验 同一个平台下的 classify 不能重复
        Resourceniche resourceDB = resourceMapper.selectResourceById(resourceniche.getId());

        if(StrUtil.isNotEmpty(resourceniche.getClassify())){
            Resourceniche resourceCheck = new Resourceniche();
            resourceCheck.setPlatformCode(resourceDB.getPlatformCode());
            resourceCheck.setIsDeleted(Constants.IS_DELETED_NO);
            resourceCheck.setClassify(resourceDB.getClassify());

            List<Resourceniche> resourceniches = resourceMapper.selectResourceList(resourceCheck);
            Resourceniche finalResource = resourceniche;
            long count = resourceniches.stream().filter(resourceniche_ -> {
                return !resourceniche_.getId().equals(finalResource.getId());
            }).count();
            if (count > 0) {
                return ResResult.error("Under platform " + resourceniches.get(0).getPlatformName() + ", The same classify exists and cannot be added");
            }
        }

        resourceniche.setUpdated((int) (DateUtil.current() / 1000));
        resourceniche.setUpdater("1");
        int result = resourceMapper.updateResource(resourceniche);

        cacheService.scanAndDeletePipelined(CacheMetaEnum.CACHE_RESOURCE.buildKey(resourceDB.getCachePattern()));

        return ResResult.success(result);
    }


    /**
     * 批量删除
     *
     * @param ids 需要删除的主键
     * @return 结果
     */
    @Transactional
    @Override
    public ResResult deleteResourceByIds(String ids, Integer logic) {
        //判断是否可以删除
        boolean check = this.checkOnline(ids);
        if (!check) {
            return ResResult.error("There are already online materials and cannot be deleted!");
        }

        if (null != logic && logic > 0) {
            //级联删除 字段 和 素材
            resourceconfigMapper.logicRemoveResourceconfigByResourceIds(Convert.toStrArray(ids));
            resourceentryrecordMapper.logicRemoveResourceconfigByResourceIds(Convert.toStrArray(ids));
            return ResResult.success(resourceMapper.logicRemoveResourceByIds(Convert.toStrArray(ids)));
        }

        resourceconfigMapper.deleteResourceconfigByResourceIds(Convert.toStrArray(ids));
        resourceentryrecordMapper.deleteResourceconfigByResourceIds(Convert.toStrArray(ids));
        int num = resourceMapper.deleteResourceByIds(Convert.toStrArray(ids));

        //redis 事务
        Arrays.stream(Convert.toStrArray(ids)).forEach(id -> {
            delResourcenicheCache(Long.parseLong(id));
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
    public ResResult deleteResourceById(Long id) {
        //redis 批量删除
        delResourcenicheCache(id);

        //级联删除
        String ids[] = new String[1];
        ids[0] = String.valueOf(id);
        resourceconfigMapper.deleteResourceconfigByResourceIds(ids);
        resourceentryrecordMapper.deleteResourceconfigByResourceIds(ids);
        return ResResult.success(resourceMapper.deleteResourceById(id));
    }

    private void delResourcenicheCache(Long id) {

        Resourceniche resourceniche = resourceMapper.selectResourceById(id);
        Resourceconfig resourceconfig = new Resourceconfig();
        resourceconfig.setResourceId(id);
        Resourceentryrecord resourceentryrecord = new Resourceentryrecord();
        resourceentryrecord.setResourceId(id);

        cacheService.scanAndDeletePipelined(CacheMetaEnum.CACHE_RESOURCE.buildKey(resourceniche.getCachePattern()));
    }

    /**
     * 获取资源资源位素材信息
     *
     * @param resourcenicheQuery
     * @return
     */
    @Override
    public ResResult<ResourcenicheVO> queryDeliveryList(ResourcenicheQuery resourcenicheQuery) {

        ResourcenicheVO resourcenicheVO;
        if (cacheService.exists(CacheMetaEnum.CACHE_RESOURCE, resourcenicheQuery.getCacheKey())) {
            String cacheVal= cacheService.get(CacheMetaEnum.CACHE_RESOURCE,resourcenicheQuery.getCacheKey());
            resourcenicheVO = GsonUtils.gsonToBean(cacheVal,ResourcenicheVO.class);
            return ResResult.success(resourcenicheVO);
        }

        Resourceniche resourceniche = CglibUtil.copy(resourcenicheQuery, Resourceniche.class);

        List<Resourceniche> resourceniches = selectResourceList(resourceniche);
        if (null == resourceniches || resourceniches.size() < 1) {
            return ResResult.error(ResResultCodeEnum.TARGET_NOT_EXISTS);
        }
        resourceniche = resourceniches.get(0);

        //获取字段配置
        ResourceconfigQuery resourceconfigQuery = new ResourceconfigQuery();
        resourceconfigQuery.setResourceId(resourceniche.getId());
        resourceconfigQuery.setIsDeleted(Constants.IS_DELETED_NO);
        List<Resourceconfig> resourceconfigs = resourceconfigService.selectResourceconfigList(resourceconfigQuery);

        //获取素材数据
        ResourceentryrecordQuery resourceentryrecordQuery = new ResourceentryrecordQuery();
        resourceentryrecordQuery.setResourceId(resourceniche.getId());
        resourceentryrecordQuery.setIsDeleted(Constants.IS_DELETED_NO);
        resourceentryrecordQuery.setStatus(Constants.STATUS_ONLINE);
        resourceentryrecordQuery.setSiteCode(resourcenicheQuery.getSiteCode());
        resourceentryrecordQuery.setSiteName(resourcenicheQuery.getSiteName());
        resourceentryrecordQuery.setTermOfValidity(1);
        List<Resourceentryrecord> resourceentryrecords = resourceentryrecordService.selectResourceentryrecordList(resourceentryrecordQuery);

        //todo 投放策略过滤

        resourcenicheVO =   CglibUtil.copy(resourceniche, ResourcenicheVO.class);

        List<ResourceconfigVO> configs = CglibUtil.copyList(resourceconfigs, ResourceconfigVO::new);
        List<ResourceentryrecordVO> records = CglibUtil.copyList(resourceentryrecords, ResourceentryrecordVO::new);
        records = records.stream().map(record -> {
            record.setMetaJsonValue(GsonUtils.gsonToMaps(record.getMetaValue()));
            record.setMetaValue("");
            return record;
        }).collect(Collectors.toList());

        resourcenicheVO.setConfigs(configs);
        resourcenicheVO.setRecords(records);

        cacheService.set(CacheMetaEnum.CACHE_RESOURCE,resourcenicheQuery.getCacheKey(),GsonUtils.gsonString(resourcenicheVO));
        return ResResult.success(resourcenicheVO);
    }

    /**
     * @param resourcenicheQuery
     * @return
     */
    @Override
    public List<Resourceniche> getResourcenicheList(ResourcenicheQuery resourcenicheQuery) {

        Resourceniche resourceniche = CglibUtil.copy(resourcenicheQuery, Resourceniche.class);

        List<Resourceniche> resourceniches = this.selectResourceList(resourceniche);

        if(CollectionUtil.isNotEmpty(resourceniches)){
            //拼接 资源位下的素材总数，上线素材总数
            resourceniches = resourceniches.parallelStream().map(resourceniche1 -> {
                ResourceentryrecordQuery resourceentryrecordQuery = new ResourceentryrecordQuery();
                resourceentryrecordQuery.setResourceId(resourceniche1.getId());
                resourceentryrecordQuery.setIsDeleted(Constants.IS_DELETED_NO);
                List<Resourceentryrecord>  resourceentryrecords =  resourceentryrecordService.selectResourceentryrecordList(resourceentryrecordQuery);
                Long count = resourceentryrecords.stream().filter(resourceentryrecord -> {
                    return Constants.STATUS_ONLINE.equals(resourceentryrecord.getStatus());
                }).count();

                resourceniche1.setRecordTotal(resourceentryrecords.size());
                resourceniche1.setRecordOnlineTotal(count.intValue());

                return resourceniche1;
            }).collect(Collectors.toList());
        }

        return resourceniches;
    }

    private boolean checkOnline(String ids) {
        Long count = resourceentryrecordService.getCountByResourceIds(ids, Constants.STATUS_ONLINE);
        if (count > 0) {
            return false;
        }
        return true;
    }
}
