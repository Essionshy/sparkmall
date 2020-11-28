package com.tingyu.sparkmall.order.exception;


import com.tingyu.sparkmall.exception.ResultException;
import com.tingyu.sparkmall.support.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 处理自定义异常 ResultException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {ResultException.class})
    public CommonResult handleResultException(ResultException e) {


        return new CommonResult(e.getCode(), e.getMessage());
    }


    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public CommonResult handleValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> errorMap = new HashMap<>();

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        fieldErrors.forEach(fieldError -> {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return new CommonResult(4000, "参数校验失败", errorMap);
    }

}
