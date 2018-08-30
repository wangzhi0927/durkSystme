package com.dpm.resource.freamwork;


import com.auth0.jwt.exceptions.TokenExpiredException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


public class RestExceptionHandler {


    private final Logger logger = LogManager.getLogger(this.getClass());


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BusinessResult errorHandler(HttpServletRequest req, Exception e) {
        if (e instanceof BusinessException) {
            logger.error("---BusinessException Handler---", e);
            return BusinessResult.failed(((BusinessException) e).getCode(), e.getMessage());
        } else {
            logger.error("---Exception Handler---", e);
            return BusinessResult.failed("服务器内部异常");
        }
    }
    @ExceptionHandler(TokenExpiredException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public BusinessResult  processValidationTokenError(TokenExpiredException ex){
        BusinessResult response = BusinessResult.failed(BusinessResult.UNAUTHORIZED_CODE, "");
        List<String> errorMessages = new ArrayList<>();
        response.setData(ex.getMessage());
        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public BusinessResult processValidationRequestError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        BusinessResult response = BusinessResult.failed(400, "");
        List<String> errorMessages = new ArrayList<>();
        fieldErrors.stream().forEach(fieldError -> errorMessages.add(fieldError.getDefaultMessage()));
        response.setData(errorMessages);
        return response;
    }
}
