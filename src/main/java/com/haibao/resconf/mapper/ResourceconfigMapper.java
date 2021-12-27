package com.haibao.resconf.mapper;

import com.haibao.resconf.domain.model.Resourceconfig;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 【资源配置-字段】Mapper接口
 *
 * @author wuque
 * @date 2021-09-03
 */
@Repository
public interface ResourceconfigMapper
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
    public List<Resourceconfig> selectResourceconfigList(Resourceconfig resourceconfig);

    /**
     * 新增
     *
     * @param resourceconfig
     * @return 结果
     */
    public int insertResourceconfig(Resourceconfig resourceconfig);

    /**
     * 修改
     *
     * @param resourceconfig
     * @return 结果
     */
    public int updateResourceconfig(Resourceconfig resourceconfig);

    /**
     * 删除
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteResourceconfigById(Long id);

    /**
     * 批量删除
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteResourceconfigByIds(String[] ids);

    int logicRemoveResourceconfigByResourceIds(String[] toStrArray);

    int deleteResourceconfigByResourceIds(String[] toStrArray);
}
