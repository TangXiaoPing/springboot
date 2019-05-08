package com.spring.demo.exception;

import com.spring.demo.constant.UcenterResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 处理请求对象属性不满足校验规则的异常信息
     *
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public UcenterResult exception(HttpServletRequest request, MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuilder builder = new StringBuilder();

        for (FieldError error : fieldErrors) {
            builder.append(error.getDefaultMessage() + "\n");
        }
        return new UcenterResult(builder.toString());
    }

    @ExceptionHandler(BindException.class)
    public UcenterResult bindExceptionHandler(BindException ex) {
        String message = getMessage(ex.getAllErrors());
        if (message == null) {
            message = ex.getMessage();
        }
        return new UcenterResult(message);
    }

    private String getMessage(List<ObjectError> errors) {
        if (errors == null || errors.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (ObjectError error : errors) {
            if (sb.length() > 0) {
                sb.append("; ");
            }
            if (error instanceof FieldError) {
                FieldError fe = (FieldError) error;
                sb.append(fe.getField()).append(fe.getDefaultMessage());
            } else {
                sb.append(error.getDefaultMessage());
            }
        }
        return sb.toString();
    }

    /**
     * 处理请求单个参数不满足校验规则的异常信息
     *
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public UcenterResult constraintViolationExceptionHandler(HttpServletRequest request, ConstraintViolationException exception) {
        logger.info(exception.getMessage());
        return new UcenterResult(exception.getMessage());
    }


    /**
     * 处理未定义的其他异常信息
     *
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public UcenterResult exceptionHandler(HttpServletRequest request, Exception exception) {
        logger.error(exception.getMessage());
        return new UcenterResult(exception.getMessage());
    }
}
