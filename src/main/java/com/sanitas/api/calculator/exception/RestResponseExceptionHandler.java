package com.sanitas.api.calculator.exception;

import io.corp.calculator.TracerImpl;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

  private TracerImpl tracer = new TracerImpl();

  @ExceptionHandler(value = {NoSuchBeanDefinitionException.class, IllegalArgumentException.class})
  protected ResponseEntity<Object> operationNotExist(
      NoSuchBeanDefinitionException ex, WebRequest request) {
    String error = "This operation does not exist";
    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, error, ex);
    tracer.trace(error);
    return new ResponseEntity<>(apiError, apiError.getStatus());
  }

}
