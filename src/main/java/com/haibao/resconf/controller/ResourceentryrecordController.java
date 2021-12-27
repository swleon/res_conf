package com.haibao.resconf.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.Page;
import com.google.common.collect.Maps;
import com.haibao.resconf.base.controller.BaseController;
import com.haibao.resconf.common.Constants;
import com.haibao.resconf.common.domain.ResResult;
import com.haibao.resconf.common.validation.SaveGroup;
import com.haibao.resconf.common.validation.UpdateGroup;
import com.haibao.resconf.domain.model.Resourceentryrecord;
import com.haibao.resconf.domain.query.ResourceentryrecordQuery;
import com.haibao.resconf.service.IResourceentryrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Map;

/**
 * @author wuque
 * @date 2021-09-03
 */
@Validated
@RestController
@RequestMapping("/api/admin/delivery/record")
@CrossOrigin(originPatterns = {"*.weshop.com*", "*.weshop-inc.com*"}, maxAge = 3600, allowCredentials = "true")
public class ResourceentryrecordController extends BaseController {

    @Autowired
    private IResourceentryrecordService resourceentryrecordService;

    /**
     * 查列表
     */
    @RequestMapping("/list")
    public ResResult list(@RequestBody ResourceentryrecordQuery resourceentryrecordQuery) {
        if (StrUtil.isEmpty(resourceentryrecordQuery.getOrderByColumn())) {
            resourceentryrecordQuery.setOrderByColumn("sort");
        }
        Page page = startPage(resourceentryrecordQuery);
        List<Resourceentryrecord> list = resourceentryrecordService.selectResourceentryrecordList(resourceentryrecordQuery);
        return ResResult.success(getDataTable(page,list));
    }

    @PostMapping("/add")
    public ResResult addSave(@RequestBody @Validated(SaveGroup.class)
                                      Resourceentryrecord resourceentryrecord) {
        return resourceentryrecordService.insertResourceentryrecord(resourceentryrecord);
    }

    /**
     * 修改保存
     */
    @PostMapping("/edit")
    public ResResult editSave(@RequestBody @Validated(UpdateGroup.class)
                                       Resourceentryrecord resourceentryrecord) {
        return resourceentryrecordService.updateResourceentryrecord(resourceentryrecord);
    }

    /**
     * 上线
     *
     * @param ids
     * @return
     */
    @PostMapping("/up")
    public ResResult up(@RequestParam(name = "ids")
                         @NotEmpty(message = "The ids cannot empty")
                                 String ids) {
        Map map = Maps.newHashMap();
        map.put("status", Constants.STATUS_ONLINE);
        map.put("ids", Convert.toStrArray(ids));
        return resourceentryrecordService.updateResourceentryrecordStatusBatchByIds(map);
    }

    /**
     * 下线
     *
     * @param ids
     * @return
     */
    @PostMapping("/down")
    public ResResult down(@RequestParam(name = "ids")
                           @NotEmpty(message = "The ids cannot empty")
                                   String ids) {
        Map map = Maps.newHashMap();
        map.put("status", Constants.STATUS_TEST);
        map.put("ids", Convert.toStrArray(ids));
        return resourceentryrecordService.updateResourceentryrecordStatusBatchByIds(map);
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    public ResResult remove(@RequestParam(name = "ids")
                             @NotEmpty(message = "The ids cannot empty")
                                     String ids) {
        return resourceentryrecordService.deleteResourceentryrecordByIds(ids);
    }
}
