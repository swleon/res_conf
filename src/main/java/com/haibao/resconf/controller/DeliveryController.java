package com.haibao.resconf.controller;

import cn.hutool.core.util.StrUtil;
import com.haibao.resconf.base.controller.BaseController;
import com.haibao.resconf.common.Constants;
import com.haibao.resconf.common.domain.ResResult;
import com.haibao.resconf.domain.query.ResourcenicheQuery;
import com.haibao.resconf.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 资源素材对外API 统一查询接口
 * @author wuque
 * @date 2021-09-03
 */
@RestController
@RequestMapping("/api/delivery")
public class DeliveryController extends BaseController
{

    @Autowired
    private IResourceService resourceService;


    @PostMapping("/query")
    public ResResult query(
            @RequestBody ResourcenicheQuery resourcenicheQuery)
    {
        if (StrUtil.isEmpty(resourcenicheQuery.getClassify())) {
            return ResResult.error("The classify not missing");
        }
        if (StrUtil.isEmpty(resourcenicheQuery.getPlatformCode())) {
            resourcenicheQuery.setPlatformCode(Constants.SITE_NAME_EN);
        }
        resourcenicheQuery.setIsDeleted(Constants.IS_DELETED_NO);

        return resourceService.queryDeliveryList(resourcenicheQuery);

    }

}
