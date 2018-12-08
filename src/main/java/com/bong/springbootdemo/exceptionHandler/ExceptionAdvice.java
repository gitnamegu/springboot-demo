package com.bong.springbootdemo.exceptionHandler;

import com.bong.springbootdemo.exception.ReportException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dabing
 * @create 2018/12/8
 * @since 1.0.0
 */
@ControllerAdvice
public class ExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(value = ReportException.class)
    public Map<String, Object> javaExceptionHandler(Exception ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", false);
        return map;
    }

}
