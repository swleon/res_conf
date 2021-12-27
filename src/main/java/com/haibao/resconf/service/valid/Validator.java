package com.haibao.resconf.service.valid;

import com.haibao.resconf.common.domain.ResResult;

import javax.validation.ValidationException;

/**
 * @author: wuque
 * @date: 2021/9/14 11:18
 * @description:
 * @param <D> data
 * @param <R> rules
 */
public interface Validator<D,R> {
    ResResult validate(D data, R rules) throws ValidationException;
}
