package com.haibao.resconf.controller;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.Page;
import com.haibao.resconf.base.controller.BaseController;
import com.haibao.resconf.common.domain.ResResult;
import com.haibao.resconf.common.page.TableDataInfo;
import com.haibao.resconf.common.validation.SaveGroup;
import com.haibao.resconf.common.validation.UpdateGroup;
import com.haibao.resconf.domain.model.Resourceconfig;
import com.haibao.resconf.domain.query.ResourceconfigQuery;
import com.haibao.resconf.service.IResourceconfigService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 资源位 字段管理
 * @author wuque
 * @date 2021-09-03
 */
@Validated
@RestController
@RequestMapping("/api/admin/delivery/config")
public class ResourceconfigController extends BaseController
{

    @Autowired
    private IResourceconfigService resourceconfigService;

    /**
     * 查询列表
     */
    @RequestMapping("/list")
    public ResponseEntity<TableDataInfo> list(@RequestBody @Validated ResourceconfigQuery resourceconfigQuery)
    {
        if (StrUtil.isEmpty(resourceconfigQuery.getOrderByColumn())){
            resourceconfigQuery.setOrderByColumn("sort");
        }
        Page page = startPage(resourceconfigQuery);
        List<Resourceconfig> list = resourceconfigService.selectResourceconfigList(resourceconfigQuery);
        return ResponseEntity.ok(getDataTable(page,list));
    }

    /**
     * 新增保存
     */
    @PostMapping("/add")
    public ResResult addSave(@RequestBody
                                  @Validated(SaveGroup.class)
                                          Resourceconfig resourceconfig)
    {
        return resourceconfigService.insertResourceconfig(resourceconfig);
    }

    /**
     * 修改保存
     */
    @PostMapping("/edit")
    public ResResult editSave(@RequestBody @Validated(UpdateGroup.class)
                                           Resourceconfig resourceconfig)
    {
        return resourceconfigService.updateResourceconfig(resourceconfig);
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    public ResResult remove(@RequestParam(name = "ids")
                                 @NotEmpty(message = "The ids cannot empty")
                                         String ids)
    {
        return resourceconfigService.deleteResourceconfigByIds(ids);
    }
}
