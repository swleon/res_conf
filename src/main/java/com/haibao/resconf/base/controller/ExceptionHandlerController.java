package com.haibao.resconf.base.controller;

import com.haibao.resconf.common.domain.ResResult;
import com.haibao.resconf.common.enums.ResResultCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * @author: wuque
 * @date: 2021/9/7 16:09
 * @description:
 */
@ControllerAdvice
public class ExceptionHandlerController {

    private static Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(value = {MethodArgumentNotValidException.class,ConstraintViolationException.class})
    public ResponseEntity hadlerException(final Exception ex, final WebRequest req){

        ResResult resResult;
        logger.error("拦截异常-",ex);

        //参数错误
        if(ex instanceof MethodArgumentNotValidException){
            BindingResult result = ((MethodArgumentNotValidException) ex).getBindingResult();
            resResult = ResResult.error(ResResultCodeEnum.PARAM_ERROR,wrapperError(result));
            return new ResponseEntity<Object>(resResult, HttpStatus.OK);
        }else if(ex instanceof ConstraintViolationException){
            resResult = ResResult.error(ResResultCodeEnum.PARAM_ERROR,ex.getMessage());
            return new ResponseEntity<Object>(resResult, HttpStatus.OK);
        }
        //其他错误
        resResult = ResResult.error(ResResultCodeEnum.PARAM_ERROR,ex.getMessage());

        return new ResponseEntity<Object>(resResult, HttpStatus.OK);
    }

    private String wrapperError(BindingResult result){

        List<ObjectError> list = result.getAllErrors();
        if(list.size() > 0){
            return list.get(0).getDefaultMessage();
        }
        return "";
    }
}
