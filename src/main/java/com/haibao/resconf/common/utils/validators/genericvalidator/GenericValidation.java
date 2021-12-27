package com.haibao.resconf.common.utils.validators.genericvalidator;

import java.util.function.Predicate;

/**
 * @author: wuque
 * @date: 2021/9/14 11:05
 * @description:
 */
public class GenericValidation<K> implements Validation<K>{

    /**
     * 断定式
     */
    private Predicate<K> predicate;


    private GenericValidation(Predicate<K> predicate) {
        this.predicate = predicate;
    }

    public static <K> GenericValidation<K> from(Predicate<K> predicate) {
        return new GenericValidation<K>(predicate);
    }

    @Override
    public GenericValidationResult test(K param) {
        return predicate.test(param) ? GenericValidationResult.ok() : GenericValidationResult.fail();
    }

}
