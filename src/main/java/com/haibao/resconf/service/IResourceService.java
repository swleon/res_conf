package com.haibao.resconf.service;

import com.haibao.resconf.common.domain.ResResult;
import com.haibao.resconf.domain.model.Resourceniche;
import com.haibao.resconf.domain.query.ResourcenicheQuery;

import java.util.List;

/**
 * Service接口
 *
 * @author wuque
 * @date 2021-09-03
 */
public interface IResourceService
{
    /**
     * 查询
     *
     * @param id 主键
     * @return
     */
    public Resourceniche selectResourceById(Long id);

    /**
     * 查询列表
     *
     * @param resource
     * @return 集合
     */
    public List<Resourceniche> selectResourceList(Resourceniche resource);

    /**
     * 新增
     *
     * @param resource
     * @return 结果
     */
    public ResResult insertResource(Resourceniche resource);

    /**
     * 修改
     *
     * @param resource
     * @return 结果
     */
    public ResResult updateResource(Resourceniche resource);

    /**
     * 批量删除
     *
     * @param ids 需要删除的主键集合
     * @return 结果
     */
    public ResResult deleteResourceByIds(String ids,Integer logic);

    /**
     * 删除信息
     *
     * @param id 主键
     * @return 结果
     */
    public ResResult deleteResourceById(Long id);

    /**
     * 根据 平台、策略 获取相关资源位素材
     * @param resourcenicheQuery
     * @return
     */
    ResResult queryDeliveryList(ResourcenicheQuery resourcenicheQuery);

    List<Resourceniche> getResourcenicheList(ResourcenicheQuery resourcenicheQuery);

}
