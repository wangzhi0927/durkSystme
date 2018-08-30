package com.dpm.web.common.freamwork;

import com.dpm.resource.freamwork.BusinessResult;
import com.dpm.resource.freamwork.ResponseAdviceHandler;
import feign.FeignException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author liuxiaoxin
 * @Descrpition
 * @Date 2018/5/13
 * @Modified By:
 */
@RestControllerAdvice
public class WebResponseAdviceHandler extends ResponseAdviceHandler {

    @ExceptionHandler(FeignException.class)
    @ResponseBody
    public BusinessResult processValidationFeignError(FeignException ex) {
        BusinessResult response = BusinessResult.failed(BusinessResult.UNAUTHORIZED_CODE, "");
        List<String> errorMessages = new ArrayList<>();
        response.setData(ex.getMessage());
        return response;
    }
}
