package com.haibao.resconf.service;

import com.haibao.resconf.common.domain.ResResult;
import com.haibao.resconf.domain.model.Resourceentryrecord;
import com.haibao.resconf.domain.query.ResourceentryrecordQuery;

import java.util.List;
import java.util.Map;

/**
 * Service接口
 *
 * @author wuque
 * @date 2021-09-03
 */
public interface IResourceentryrecordService
{

    /**
     * 查询
     *
     * @param id 主键
     * @return
     */
    public Resourceentryrecord selectResourceentryrecordById(Long id);

    /**
     * 查询列表
     *
     * @param resourceentryrecordQuery
     * @return 集合
     */
    public List<Resourceentryrecord> selectResourceentryrecordList(ResourceentryrecordQuery resourceentryrecordQuery);

    /**
     * 新增
     *
     * @param resourceentryrecord
     * @return 结果
     */
    public ResResult insertResourceentryrecord(Resourceentryrecord resourceentryrecord);

    /**
     * 修改
     *
     * @param resourceentryrecord
     * @return 结果
     */
    public ResResult updateResourceentryrecord(Resourceentryrecord resourceentryrecord);

    /**
     * 批量删除
     *
     * @param ids 需要删除的主键集合
     * @return 结果
     */
    public ResResult deleteResourceentryrecordByIds(String ids);

    /**
     * 删除信息
     *
     * @param id 主键
     * @return 结果
     */
    public ResResult deleteResourceentryrecordById(Long id);

    ResResult updateResourceentryrecordStatusBatchByIds(Map map);

    Long getCountByResourceIds(String ids, String statusOnline);
}
