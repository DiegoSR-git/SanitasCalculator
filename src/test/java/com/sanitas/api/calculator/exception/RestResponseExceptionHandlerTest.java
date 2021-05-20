package com.sanitas.api.calculator.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

@SpringBootTest
class RestResponseExceptionHandlerTest {

  @Autowired
  private RestResponseExceptionHandler restResponseExceptionHandler;

  private final WebRequest request = mock(WebRequest.class);

  @BeforeEach
  public void onBefore() {
    restResponseExceptionHandler = new RestResponseExceptionHandler();
  }

  @Test
  void handlingNoSuchBeanException_shouldBeReturnEntityWithBadRequestCode() {
    ResponseEntity<Object>
        result = restResponseExceptionHandler.operationNotExist(new NoSuchBeanDefinitionException("No bean available"), request);
    assertNotNull(result);
    assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());

  }
}
