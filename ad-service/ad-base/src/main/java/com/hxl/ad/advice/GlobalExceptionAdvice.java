package com.hxl.ad.advice;

import com.hxl.ad.exception.AdException;
import com.hxl.ad.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 全局异常处理
 * @Author: hanxuanliang
 * @Date: 2020/2/21 12:41
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = AdException.class)
    public CommonResponse<String> handlerAdException(HttpServletRequest req, AdException ex) {

        CommonResponse<String> response = new CommonResponse<>(-1, "business error");
        response.setData(ex.getMessage());
        return response;
    }
}
