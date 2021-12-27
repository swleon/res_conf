package com.haibao.resconf.common.utils.validators.genericvalidator;

import java.util.Optional;

/**
 * @author: wuque
 * @date: 2021/9/14 11:01
 * @description:
 */
public class GenericValidationResult {

    private boolean valid;

    public boolean isValid() {
        return valid;
    }

    private GenericValidationResult(boolean valid) {
        this.valid = valid;
    }

    public static GenericValidationResult ok() {
        return new GenericValidationResult(true);
    }

    public static GenericValidationResult fail() {
        return new GenericValidationResult(false);
    }

    public Optional<String> getFieldNameIfInvalid(String field) {
        return this.valid ? Optional.empty() : Optional.of(field);
    }
}
