package com.sanitas.api.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AddServiceTest {

  @Autowired
  private AddService addService;

  @Test
  void calculateAddition_whenSuccess_shouldReturnExpectedResult() {

    double expectedResult = 9;
    Long firstNumber = 5L;
    Long secondNumber = 4L;

    Double result = addService.calculate(firstNumber, secondNumber);

    assertNotNull(result);
    assertEquals(result, expectedResult);
  }

}
