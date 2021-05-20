package com.sanitas.api.calculator.registry;

@FunctionalInterface
public interface ArithmeticOperationService {
  double calculate(Long firstNumber, Long secondNumber);
}
