package com.sanitas.api.calculator.service;

import com.sanitas.api.calculator.registry.ArithmeticOperationService;
import org.springframework.stereotype.Service;

@Service("add")
public class AddService implements ArithmeticOperationService {

  @Override
  public double calculate(Long firstNumber, Long secondNumber) {
    return firstNumber + secondNumber;
  }
}
