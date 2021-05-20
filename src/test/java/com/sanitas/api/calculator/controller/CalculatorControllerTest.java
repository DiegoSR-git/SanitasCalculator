package com.sanitas.api.calculator.controller;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.sanitas.api.calculator.Application;
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

  private ResponseEntity<Double> calculate(String firstNumber, String secondNumber, String operation) throws URISyntaxException {
    RestTemplate restTemplate = new RestTemplate();

    final String baseUrl = "http://localhost:" + randomLocalServerPort +
        "/calculator/?firstNumber=" + firstNumber +
        "&secondNumber=" + secondNumber + "&operation=" + operation;
    URI uri = new URI(baseUrl);

    return restTemplate.getForEntity(uri, Double.class);
  }

  @Test
  void calculateAdditionWithAllParameters_shoulReturnOkStatusCode() throws URISyntaxException {
    ResponseEntity<Double> result = calculate("5", "4", "add");

    assertNotNull(result);
    assertEquals(HttpStatus.OK, result.getStatusCode());
  }

  @Test
  void calculateAdditionWithMissingNumber_shouldReturnKoStatusCode() {
    assertThrows(HttpClientErrorException.class, () -> calculate("", "4", "add"));
  }

  @Test
  void calculateSubtractionWithAllParameters_shoulReturnOkStatusCode() throws URISyntaxException {
    ResponseEntity<Double> result = calculate("5", "4", "sub");

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
