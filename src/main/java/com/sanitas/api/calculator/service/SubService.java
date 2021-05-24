package com.sanitas.api.calculator.service;

import com.sanitas.api.calculator.registry.ArithmeticOperationService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;

@Service("sub")
public class SubService implements ArithmeticOperationService {

  @Override
  public BigDecimal calculate(BigDecimal firstNumber, BigDecimal secondNumber) {
    return firstNumber.subtract(secondNumber).setScale(2, RoundingMode.HALF_EVEN);
  }
}
