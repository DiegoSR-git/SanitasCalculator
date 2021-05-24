package com.sanitas.api.calculator.registry;

import java.math.BigDecimal;

@FunctionalInterface
public interface ArithmeticOperationService {

  BigDecimal calculate(BigDecimal firstNumber, BigDecimal secondNumber);
}
