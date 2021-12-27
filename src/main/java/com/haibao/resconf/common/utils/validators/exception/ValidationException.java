package com.haibao.resconf.common.utils.validators.exception;

/**
 * @author: wuque
 * @date: 2021/9/14 11:25
 * @description:
 */
public class ValidationException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 3746951378297949885L;

    public ValidationException(String message) {
        super(message);
    }
}
