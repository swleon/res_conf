package com.haibao.resconf.service;

import com.haibao.resconf.common.domain.ResResult;
import com.haibao.resconf.domain.model.Resourceconfig;
import com.haibao.resconf.domain.query.ResourceconfigQuery;

import java.util.List;

/**
 * Service接口
 *
 * @author wuque
 * @date 2021-09-03
 */
public interface IResourceconfigService
{
    /**
     * 查询
     *
     * @param id 主键
     * @return
     */
    public Resourceconfig selectResourceconfigById(Long id);

    /**
     * 查询列表
     *
     * @param resourceconfig
     * @return 集合
     */
    public List<Resourceconfig> selectResourceconfigList(ResourceconfigQuery resourceconfig);

    /**
     * 新增
     *
     * @param resourceconfig
     * @return 结果
     */
    public ResResult insertResourceconfig(Resourceconfig resourceconfig);

    /**
     * 修改
     *
     * @param resourceconfig
     * @return 结果
     */
    public ResResult updateResourceconfig(Resourceconfig resourceconfig);

    /**
     * 批量删除
     *
     * @param ids 需要删除的主键集合
     * @return 结果
     */
    public ResResult deleteResourceconfigByIds(String ids);

    /**
     * 删除信息
     *
     * @param id 主键
     * @return 结果
     */
    public ResResult deleteResourceconfigById(Long id);
}
