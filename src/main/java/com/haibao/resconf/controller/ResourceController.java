package com.haibao.resconf.controller;

import com.github.pagehelper.Page;
import com.haibao.resconf.base.controller.BaseController;
import com.haibao.resconf.common.Constants;
import com.haibao.resconf.common.domain.ResResult;
import com.haibao.resconf.common.page.TableDataInfo;
import com.haibao.resconf.common.validation.SaveGroup;
import com.haibao.resconf.common.validation.UpdateGroup;
import com.haibao.resconf.domain.model.Resourceniche;
import com.haibao.resconf.domain.query.ResourcenicheQuery;
import com.haibao.resconf.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 资源位 管理
 * @author wuque
 * @date 2021-09-03
 */
@Validated
@RestController
@RequestMapping("/api/admin/delivery")
public class ResourceController extends BaseController
{

    @Autowired
    private IResourceService resourceService;

    /**
     * 资源位列表 Resourceniche list
     * @param resourcenicheQuery
     * @return
     */
    @RequestMapping("/list")
    public ResponseEntity<TableDataInfo> list(@RequestBody ResourcenicheQuery resourcenicheQuery)
    {
        resourcenicheQuery.setIsDeleted(Constants.IS_DELETED_NO);
        if(null != resourcenicheQuery.getSearchYourself() &&
          1 == resourcenicheQuery.getSearchYourself()){
            resourcenicheQuery.setCreater("admin");
        }

        Page page = startPage(resourcenicheQuery);
        List<Resourceniche> list = resourceService.getResourcenicheList(resourcenicheQuery);

        return ResponseEntity.ok(getDataTable(page,list));
    }

    @GetMapping("/get/{id:\\d+}")
    public ResResult<Resourceniche> get(@PathVariable(value = "id") Long id)
    {
        Resourceniche resourceniche = resourceService.selectResourceById(id);
        if(null == resourceniche){
            return ResResult.error("resource niche is not found!");
        }
        return ResResult.success(resourceniche);
    }

    /**
     * 新增保存
     */
    @PostMapping("/add")
    public ResResult addSave(@RequestBody @Validated(SaveGroup.class) Resourceniche resource)
    {
        return resourceService.insertResource(resource);
    }

    /**
     * 修改保存
     */
    @PostMapping("/edit")
    public ResResult editSave(@RequestBody @Validated(UpdateGroup.class) Resourceniche resource)
    {
        return resourceService.updateResource(resource);
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    public ResResult remove(@RequestParam(name = "ids")
                             @NotEmpty(message = "The ids cannot empty")
                             String ids,
                             @RequestParam(name = "logic",defaultValue = "1") Integer logic)
    {
        return resourceService.deleteResourceByIds(ids,logic);
    }

}
