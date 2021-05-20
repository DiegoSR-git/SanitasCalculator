package com.sanitas.api.calculator.controller;

import com.sanitas.api.calculator.registry.ServiceRegistry;
import io.corp.calculator.TracerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

  @Autowired
  private ServiceRegistry serviceRegistry;

  private TracerImpl tracer = new TracerImpl();

  @GetMapping
  public ResponseEntity<Double> calulate(@RequestParam(name = "firstNumber") Long firstNumber,
      @RequestParam(name = "secondNumber") Long secondNumber,
      @RequestParam(name = "operation") String operation) {

    double calculateResult  = serviceRegistry.getService(operation).calculate(firstNumber,secondNumber);
    tracer.trace("The result of the operation is: " + calculateResult);
    return new ResponseEntity<>(calculateResult, HttpStatus.OK);
  }

}
