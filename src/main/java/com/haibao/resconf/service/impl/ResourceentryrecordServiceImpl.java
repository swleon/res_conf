package com.haibao.resconf.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.extra.cglib.CglibUtil;
import com.google.common.collect.Lists;
import com.haibao.resconf.common.Constants;
import com.haibao.resconf.common.cache.ICacheService;
import com.haibao.resconf.common.domain.ResResult;
import com.haibao.resconf.common.enums.CacheMetaEnum;
import com.haibao.resconf.common.utils.GsonUtils;
import com.haibao.resconf.domain.model.Resourceconfig;
import com.haibao.resconf.domain.model.Resourceentryrecord;
import com.haibao.resconf.domain.model.Resourceniche;
import com.haibao.resconf.domain.query.ResourceentryrecordQuery;
import com.haibao.resconf.mapper.ResourceMapper;
import com.haibao.resconf.mapper.ResourceconfigMapper;
import com.haibao.resconf.mapper.ResourceentryrecordMapper;
import com.haibao.resconf.service.IResourceentryrecordService;
import com.haibao.resconf.service.valid.ResourceconfigSaveValidator;
import com.haibao.resconf.service.valid.ResourceconfigUpdateValidator;
import com.haibao.resconf.service.valid.Validator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service业务层处理
 *
 * @author wuque
 * @date 2021-09-03
 */
@Service
public class ResourceentryrecordServiceImpl implements IResourceentryrecordService {
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private ResourceentryrecordMapper resourceentryrecordMapper;
    @Autowired
    private ResourceconfigMapper resourceconfigMapper;
    @Autowired
    private ICacheService cacheService;


    /**
     * 查询
     *
     * @param id 主键
     * @return
     */
    @Override
    public Resourceentryrecord selectResourceentryrecordById(Long id) {
        return resourceentryrecordMapper.selectResourceentryrecordById(id);
    }

    /**
     * 查询列表
     *
     * @param resourceentryrecordQuery
     * @return
     */
    @Override
    public List<Resourceentryrecord> selectResourceentryrecordList(ResourceentryrecordQuery resourceentryrecordQuery) {

        Resourceentryrecord resourceentryrecord = CglibUtil.copy(resourceentryrecordQuery, Resourceentryrecord.class);
        if (null == resourceentryrecord.getIsDeleted()) {
            resourceentryrecord.setIsDeleted(Constants.IS_DELETED_NO);
        }

        List<Resourceentryrecord> resourceentryrecords = resourceentryrecordMapper.selectResourceentryrecordList(resourceentryrecord);

        return resourceentryrecords;
    }

    /**
     * 新增
     *
     * @param resourceentryrecord
     * @return 结果
     */
    @Transactional
    @Override
    public ResResult insertResourceentryrecord(Resourceentryrecord resourceentryrecord) {

        resourceentryrecord.setIsDeleted(Constants.IS_DELETED_NO);
        resourceentryrecord.setStatus(Constants.STATUS_TEST);
        resourceentryrecord.setMetaValue(GsonUtils.gsonString(resourceentryrecord.getMetaJsonValue()));
        resourceentryrecord.setSort(null == resourceentryrecord.getSort() ? 0 : resourceentryrecord.getSort());
        resourceentryrecord.setCreated((int) (DateUtil.current() / 1000));
        resourceentryrecord.setUpdated((int) (DateUtil.current() / 1000));
        resourceentryrecord.setCreater("1");
        resourceentryrecord.setUpdater("1");

        ResResult resResult = checkLegitimate(resourceentryrecord,Constants.OPERATION_METHOD_SAVE);
        if (!resResult.isSuccess()) {
            return resResult;
        }

        return ResResult.success(resourceentryrecordMapper.insertResourceentryrecord(resourceentryrecord));
    }

    /**
     * 修改
     *
     * @param resourceentryrecord
     * @return 结果
     */
    @Transactional
    @Override
    public ResResult updateResourceentryrecord(Resourceentryrecord resourceentryrecord) {

        if (null != resourceentryrecord.getMetaJsonValue()
                && resourceentryrecord.getMetaJsonValue().size() > 0) {
            resourceentryrecord.setMetaValue(GsonUtils.gsonString(resourceentryrecord.getMetaJsonValue()));
        }

        ResResult ResResult = checkLegitimate(resourceentryrecord,Constants.OPERATION_METHOD_UPDATE);
        if (!ResResult.isSuccess()) {
            return ResResult;
        }

        //修改完直接下线
        resourceentryrecord.setStatus(Constants.STATUS_TEST);
        resourceentryrecord.setUpdated((int) (DateUtil.current() / 1000));
        resourceentryrecord.setUpdater("1");
        int num = resourceentryrecordMapper.updateResourceentryrecord(resourceentryrecord);

        Resourceentryrecord resourceentryrecordDB = resourceentryrecordMapper.selectResourceentryrecordById(resourceentryrecord.getId());
        Resourceniche resourceniche = resourceMapper.selectResourceById(resourceentryrecordDB.getResourceId());
        cacheService.scanAndDelete(CacheMetaEnum.CACHE_RESOURCE, resourceniche.getCachePattern());

        return ResResult.success(num);
    }

    /**
     * 批量删除
     *
     * @param ids 需要删除的主键
     * @return 结果
     */
    @Transactional
    @Override
    public ResResult deleteResourceentryrecordByIds(String ids) {

        List<Resourceentryrecord> resourceentryrecords = Arrays.stream(Convert.toStrArray(ids))
                .distinct().parallel().map(id -> {
                    return resourceentryrecordMapper.selectResourceentryrecordById(Long.parseLong(id));
                }).collect(Collectors.toList());

        long count = resourceentryrecords.stream().filter(resourceentryrecord -> {
            return !Constants.STATUS_ONLINE.equals(resourceentryrecord.getStatus());
        }).count();

        if (resourceentryrecords.size() > count) {
            return ResResult.error("It is not allowed to delete the material in the online!");
        }

        return ResResult.success(resourceentryrecordMapper.deleteResourceentryrecordByIds(Convert.toStrArray(ids)));
    }

    /**
     * 删除信息
     *
     * @param id 主键
     * @return 结果
     */
    @Transactional
    @Override
    public ResResult deleteResourceentryrecordById(Long id) {
        Resourceentryrecord resourceentryrecord = resourceentryrecordMapper.selectResourceentryrecordById(id);
        if (Constants.STATUS_ONLINE.equals(resourceentryrecord.getStatus())) {
            return ResResult.error("The material on the line cannot be deleted");
        }

        return ResResult.success(resourceentryrecordMapper.deleteResourceentryrecordById(id));
    }

    /**
     * 上线/下线
     * @param map
     * @return
     */
    @Transactional
    @Override
    public ResResult updateResourceentryrecordStatusBatchByIds(Map map) {

        String ids[] = (String[]) map.get("ids");

        //校验所有字段对应的值是否合法与必须
        //上线
        if (Constants.STATUS_ONLINE.equals(map.get("status"))) {
            ResResult ResResult = checkLegitimateByIds(ids);
            if (!ResResult.isSuccess()) {
                return ResResult;
            }
        }

        int num = resourceentryrecordMapper.updateResourceentryrecordStatusBatchByIds(map);

        Set<Long> resourceIdSet = Arrays.stream(ids).distinct().parallel().map(id -> {
            Resourceentryrecord resourceentryrecord = resourceentryrecordMapper.selectResourceentryrecordById(Long.parseLong(id));
            return resourceentryrecord.getResourceId();
        }).collect(Collectors.toSet());

        resourceIdSet.parallelStream().forEach(resourceId -> {
            Resourceniche resourceniche = resourceMapper.selectResourceById(resourceId);
            cacheService.scanAndDelete(CacheMetaEnum.CACHE_RESOURCE, resourceniche.getCachePattern());
        });

        return ResResult.success(num);
    }

    @Override
    public Long getCountByResourceIds(String ids, String status) {
        return resourceentryrecordMapper.getCountByResourceIds(Convert.toStrArray(ids), status);
    }


    /**
     * 批量校验合法性
     *
     * @param ids
     */
    private ResResult checkLegitimateByIds(String[] ids) {
        List<ResResult> resResults = Lists.newArrayList();

        List<ResResult> finalResResults = resResults;
        Arrays.stream(ids).distinct().parallel().forEach(id -> {
            Resourceentryrecord resourceentryrecord = selectResourceentryrecordById(Long.parseLong(id));
            finalResResults.add(checkLegitimate(resourceentryrecord , Constants.OPERATION_METHOD_SAVE));
        });

        resResults = finalResResults.stream().filter(resResult -> {
            return !resResult.isSuccess();
        }).collect(Collectors.toList());

        if (resResults.size() > 0) {
            List<String> msgs = resResults.stream().map(resResult -> {
                return resResult.getMsg();
            }).collect(Collectors.toList());
            return ResResult.error(StringUtils.join(msgs, ";"));
        }
        return ResResult.success();
    }

    /**
     * 校验单个素材合法性
     * @param resourceentryrecord
     * @return
     */
    private ResResult checkLegitimate(Resourceentryrecord resourceentryrecord,String type) {

        Resourceconfig resourceconfig = new Resourceconfig();
        resourceconfig.setResourceId(resourceentryrecord.getResourceId());
        List<Resourceconfig> resourceconfigs = resourceconfigMapper.selectResourceconfigList(resourceconfig);
        Map fieldMap = resourceentryrecord.getMetaJsonValue();

        Validator getValidatorInstance;
        if(Constants.OPERATION_METHOD_UPDATE.equals(type)){
            getValidatorInstance = new ResourceconfigUpdateValidator();
        }else{
            getValidatorInstance = new ResourceconfigSaveValidator();
        }

        getValidatorInstance.validate(fieldMap, resourceconfigs);

        return ResResult.success();
    }

}
