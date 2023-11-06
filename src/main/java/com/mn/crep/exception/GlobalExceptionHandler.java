package com.mn.crep.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ApplicationException.class)
    protected ResponseEntity<Object> handleBaseApplicationException(ApplicationException ex, WebRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;
        return handleExceptionInternal(ex, ex.getMessage(), null, status, request);
    }
}
