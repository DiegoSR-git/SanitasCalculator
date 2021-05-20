package com.sanitas.api.calculator.service;

import com.sanitas.api.calculator.registry.ArithmeticOperationService;
import org.springframework.stereotype.Service;

@Service("sub")
public class SubService implements ArithmeticOperationService {

  @Override
  public double calculate(Long firstNumber, Long secondNumber) {
    return firstNumber - secondNumber;
  }
}
