package com.sanitas.api.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SubServiceTest {

  @Autowired
  private SubService subService;

  @Test
  void calculateSubtraction_whenSuccess_shouldReturnExpectedResult() {

    BigDecimal expectedResult = new BigDecimal(1).setScale(2, RoundingMode.HALF_EVEN);
    BigDecimal firstNumber = new BigDecimal(5);
    BigDecimal secondNumber = new BigDecimal(4);

    BigDecimal result = subService.calculate(firstNumber, secondNumber);

    assertNotNull(result);
    assertEquals(result, expectedResult);
  }

  @Test
  void calculateSubtractionWithBothDecimals_whenSuccess_shouldReturnExpectedResult() {

    BigDecimal expectedResult = new BigDecimal(0.9).setScale(2, RoundingMode.HALF_EVEN);
    BigDecimal firstNumber = new BigDecimal(5.1);
    BigDecimal secondNumber = new BigDecimal(4.2);

    BigDecimal result = subService.calculate(firstNumber, secondNumber);

    assertNotNull(result);
    assertEquals(expectedResult, result);
  }

  @Test
  void calculateSubtractionWithOneDecimal_whenSuccess_shouldReturnExpectedResult() {

    BigDecimal expectedResult = new BigDecimal(0.7).setScale(2, RoundingMode.HALF_EVEN);
    BigDecimal firstNumber = new BigDecimal(5);
    BigDecimal secondNumber = new BigDecimal(4.30);

    BigDecimal result = subService.calculate(firstNumber, secondNumber);

    assertNotNull(result);
    assertEquals(expectedResult, result);
  }

  @Test
  void calculateSubtractionWithMoreThanTwoDecimalPlaces_whenSuccess_shouldReturnExpectedResult() {

    BigDecimal expectedResult = new BigDecimal(0.7).setScale(2, RoundingMode.HALF_EVEN);
    BigDecimal firstNumber = new BigDecimal(5);
    BigDecimal secondNumber = new BigDecimal(4.30123);

    BigDecimal result = subService.calculate(firstNumber, secondNumber);

    assertNotNull(result);
    assertEquals(expectedResult, result);
  }
}
