package com.sanitas.api.calculator.config;

import com.sanitas.api.calculator.registry.ServiceRegistry;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArithmeticOperationConfig {

  @Bean
  public FactoryBean<?> factoryBean() {
    final ServiceLocatorFactoryBean bean = new ServiceLocatorFactoryBean();
    bean.setServiceLocatorInterface(ServiceRegistry.class);
    return bean;
  }
}
