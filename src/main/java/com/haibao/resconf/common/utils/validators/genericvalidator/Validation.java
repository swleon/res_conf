package com.haibao.resconf.common.utils.validators.genericvalidator;

/**
 * 校验规则，用于扩展校验规则
 * @author: wuque
 * @date: 2021/9/14 10:41
 * @description:
 */
@FunctionalInterface //jdk8函数式接口定义
public interface Validation<K> {
    public GenericValidationResult test(K param);

    default Validation<K> and(Validation<K> other) {
        return (param) -> {
            GenericValidationResult result = this.test(param);
            return !result.isValid() ? result : other.test(param);
        };
    }

    default Validation<K> or(Validation<K> other) {
        return (param) -> {
            GenericValidationResult result = this.test(param);
            return result.isValid() ? result : other.test(param);
        };
    }
}
