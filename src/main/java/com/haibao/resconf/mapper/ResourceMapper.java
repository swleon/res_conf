package com.haibao.resconf.mapper;

import com.haibao.resconf.domain.model.Resourceniche;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 【资源定义】Mapper接口
 *
 * @author wuque
 * @date 2021-09-03
 */
@Repository
public interface ResourceMapper
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
    public int insertResource(Resourceniche resource);

    /**
     * 修改
     *
     * @param resource
     * @return 结果
     */
    public int updateResource(Resourceniche resource);

    /**
     * 删除
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteResourceById(Long id);

    /**
     * 批量删除
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteResourceByIds(String[] ids);

    int logicRemoveResourceByIds(String[] toStrArray);
}
