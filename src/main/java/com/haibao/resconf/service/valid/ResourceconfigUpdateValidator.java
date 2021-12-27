package com.haibao.resconf.service.valid;

import com.haibao.resconf.common.domain.ResResult;
import com.haibao.resconf.common.exception.ValidationException;
import com.haibao.resconf.domain.model.Resourceconfig;

import java.util.List;
import java.util.Map;

/**
 * 素材专用 校验器
 * @author: wuque
 * @date: 2021/9/14 11:15
 * @description:
 */
public class ResourceconfigUpdateValidator implements Validator<Map<String,Object>, List<Resourceconfig>> {

    @Override
    public ResResult validate(Map<String,Object> data, List<Resourceconfig> resourceconfigs) {

        StringBuilder errorFields = new StringBuilder();

        resourceconfigs.forEach(resourceconfig1 -> {

            Object value = data.getOrDefault(resourceconfig1.getMetaKey(),"");
            //必填项
//            if (Constants.IS_REQUIRED_YES.equals(resourceconfig1.getRequired())) {
//                errorFields.append(ValidatorUtil.notNullString.and(ValidatorUtil.notEmptyString)
//                        .and(ValidatorUtil.stringBetween(1, 10000)).test(String.valueOf(value))
//                        .getFieldNameIfInvalid(" Please specify valid '"+resourceconfig1.getMetaKey()+"';").orElse(""));
//            }

        });

        String errors = errorFields.toString();
        if (!errors.isEmpty()) {
            try {
                throw new ValidationException(errors);
            } catch (ValidationException e) {
                e.printStackTrace();
            }
        }

        return ResResult.success();
    }
}
