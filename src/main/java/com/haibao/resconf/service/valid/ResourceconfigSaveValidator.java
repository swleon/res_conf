package com.haibao.resconf.service.valid;

import com.haibao.resconf.common.Constants;
import com.haibao.resconf.common.domain.ResResult;
import com.haibao.resconf.common.utils.validators.genericvalidator.ValidatorUtil;
import com.haibao.resconf.domain.model.Resourceconfig;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Map;

/**
 * 素材专用 校验器
 * @author: wuque
 * @date: 2021/9/14 11:15
 * @description:
 */
public class ResourceconfigSaveValidator implements Validator<Map<String,Object>, List<Resourceconfig>> {

    @Override
    public ResResult validate(Map<String,Object> data, List<Resourceconfig> resourceconfigs) throws ValidationException {

        StringBuilder errorFields = new StringBuilder();

        resourceconfigs.forEach(resourceconfig1 -> {

            //若配置了默认值，自动填充
            Object value = data.getOrDefault(resourceconfig1.getMetaKey(),resourceconfig1.getDefaultValue());
            //必填项
            if (Constants.IS_REQUIRED_YES.equals(resourceconfig1.getRequired())) {
                errorFields.append(ValidatorUtil.notNullString.and(ValidatorUtil.notEmptyString)
                        .and(ValidatorUtil.stringBetween(1, 10000000)).test(String.valueOf(value))
                        .getFieldNameIfInvalid(" Please specify valid '"+resourceconfig1.getMetaKey()+"';").orElse(""));
            }

            data.put(resourceconfig1.getMetaKey(),value);

        });

        String errors = errorFields.toString();
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }

        return ResResult.success();
    }
}
