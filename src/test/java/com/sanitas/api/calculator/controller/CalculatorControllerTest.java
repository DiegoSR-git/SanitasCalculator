package com.sanitas.api.calculator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.sanitas.api.calculator.Application;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
class CalculatorControllerTest {

  @LocalServerPort
  int randomLocalServerPort;

  private ResponseEntity<BigDecimal> calculate(String firstNumber, String secondNumber, String operation) throws URISyntaxException {
    RestTemplate restTemplate = new RestTemplate();

    final String baseUrl = "http://localhost:" + randomLocalServerPort +
        "/calculator/?firstNumber=" + firstNumber +
        "&secondNumber=" + secondNumber + "&operation=" + operation;
    URI uri = new URI(baseUrl);

    return restTemplate.getForEntity(uri, BigDecimal.class);
  }

  @Test
  void calculateAdditionWithAllParameters_shoulReturnOkStatusCode() throws URISyntaxException {
    ResponseEntity<BigDecimal> result = calculate("5", "4", "add");

    assertNotNull(result);
    assertEquals(HttpStatus.OK, result.getStatusCode());
  }

  @Test
  void calculateAdditionWithAllParametersWithDecimals_shoulReturnOkStatusCode() throws URISyntaxException {
    ResponseEntity<BigDecimal> result = calculate("5.3", "4.7012", "add");

    assertNotNull(result);
    assertEquals(HttpStatus.OK, result.getStatusCode());
  }

  @Test
  void calculateSubtractionWithAllParametersAndOneWithDecimals_shoulReturnOkStatusCode() throws URISyntaxException {
    ResponseEntity<BigDecimal> result = calculate("5", "4.70", "sub");

    assertNotNull(result);
    assertEquals(HttpStatus.OK, result.getStatusCode());
  }

  @Test
  void calculateSubtractionWithAllParametersWithDecimals_shoulReturnOkStatusCode() throws URISyntaxException {
    ResponseEntity<BigDecimal> result = calculate("5.3", "4.70", "sub");

    assertNotNull(result);
    assertEquals(HttpStatus.OK, result.getStatusCode());
  }

  @Test
  void calculateAdditionWithAllParametersAndOneWithDecimals_shoulReturnOkStatusCode() throws URISyntaxException {
    ResponseEntity<BigDecimal> result = calculate("5", "4.7012", "add");

    assertNotNull(result);
    assertEquals(HttpStatus.OK, result.getStatusCode());
  }

  @Test
  void calculateAdditionWithMissingNumber_shouldReturnKoStatusCode() {
    assertThrows(HttpClientErrorException.class, () -> calculate("", "4", "add"));
  }

  @Test
  void calculateSubtractionWithAllParameters_shoulReturnOkStatusCode() throws URISyntaxException {
    ResponseEntity<BigDecimal> result = calculate("5", "4", "sub");

    assertNotNull(result);
    assertEquals(HttpStatus.OK, result.getStatusCode());
  }

  @Test
  void calculateSubtractionWithMissingNumber_shouldReturnKoStatusCode() {
    assertThrows(HttpClientErrorException.class, () -> calculate("", "4", "sub"));
  }

  @Test
  void calculateWithOtherOperation_shouldReturnKoStatusCode() {
    assertThrows(HttpClientErrorException.class, () -> calculate("", "4", "div"));
  }

}
