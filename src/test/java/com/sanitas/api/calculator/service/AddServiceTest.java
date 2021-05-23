package com.sanitas.api.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AddServiceTest {

  @Autowired
  private AddService addService;

  @Test
  void calculateAddition_whenSuccess_shouldReturnExpectedResult() {

    BigDecimal expectedResult = new BigDecimal(9).setScale(2, RoundingMode.HALF_EVEN);
    ;
    BigDecimal firstNumber = new BigDecimal(5);
    BigDecimal secondNumber = new BigDecimal(4);

    BigDecimal result = addService.calculate(firstNumber, secondNumber);

    assertNotNull(result);
    assertEquals(result, expectedResult);
  }

  @Test
  void calculateAdditionWithBothDecimals_whenSuccess_shouldReturnExpectedResult() {

    BigDecimal expectedResult = new BigDecimal(9.30).setScale(2, RoundingMode.HALF_EVEN);
    BigDecimal firstNumber = new BigDecimal(5.1);
    BigDecimal secondNumber = new BigDecimal(4.2);

    BigDecimal result = addService.calculate(firstNumber, secondNumber);

    assertNotNull(result);
    assertEquals(expectedResult, result);
  }

  @Test
  void calculateAdditionWithOneDecimal_whenSuccess_shouldReturnExpectedResult() {

    BigDecimal expectedResult = new BigDecimal(9.30).setScale(2, RoundingMode.HALF_EVEN);
    BigDecimal firstNumber = new BigDecimal(5);
    BigDecimal secondNumber = new BigDecimal(4.30);

    BigDecimal result = addService.calculate(firstNumber, secondNumber);

    assertNotNull(result);
    assertEquals(expectedResult, result);
  }

  @Test
  void calculateAdditionWithMoreThanTwoDecimalPlaces_whenSuccess_shouldReturnExpectedResult() {

    BigDecimal expectedResult = new BigDecimal(9.30).setScale(2, RoundingMode.HALF_EVEN);
    BigDecimal firstNumber = new BigDecimal(5);
    BigDecimal secondNumber = new BigDecimal(4.30123);

    BigDecimal result = addService.calculate(firstNumber, secondNumber);

    assertNotNull(result);
    assertEquals(expectedResult, result);
  }
}
