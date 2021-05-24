package com.sanitas.api.calculator.registry;

public interface ServiceRegistry {

  ArithmeticOperationService getService(String serviceName);
}
