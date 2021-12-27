package com.haibao.resconf.mapper;

import com.haibao.resconf.domain.model.Resourceentryrecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 【素材 记录】Mapper接口
 *
 * @author wuque
 * @date 2021-09-03
 */
@Repository
public interface ResourceentryrecordMapper
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
     * @param resourceentryrecord
     * @return 集合
     */
    public List<Resourceentryrecord> selectResourceentryrecordList(Resourceentryrecord resourceentryrecord);

    /**
     * 新增
     *
     * @param resourceentryrecord
     * @return 结果
     */
    public int insertResourceentryrecord(Resourceentryrecord resourceentryrecord);

    /**
     * 修改
     *
     * @param resourceentryrecord
     * @return 结果
     */
    public int updateResourceentryrecord(Resourceentryrecord resourceentryrecord);

    /**
     * 删除
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteResourceentryrecordById(Long id);

    /**
     * 批量删除
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteResourceentryrecordByIds(String[] ids);

    int logicRemoveResourceconfigByResourceIds(String[] toStrArray);

    int deleteResourceconfigByResourceIds(String[] toStrArray);

    int updateResourceentryrecordStatusBatchByIds(Map map);

    Long getCountByResourceIds(@Param(value = "ids")String[] ids, @Param(value = "status") String status);
}
