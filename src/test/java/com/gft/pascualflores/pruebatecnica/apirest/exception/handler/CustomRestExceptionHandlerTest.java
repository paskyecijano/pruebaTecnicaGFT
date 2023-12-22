package com.gft.pascualflores.pruebatecnica.apirest.exception.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.gft.pascualflores.pruebatecnica.apirest.data.ErrorResponseDto;
import com.gft.pascualflores.pruebatecnica.apirest.exception.PriceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class CustomRestExceptionHandlerTest {
  @InjectMocks
  private CustomRestExceptionHandler customRestExceptionHandler;

  @Test
  void testHandleAll() {
    ResponseEntity<Object> actualHandleAllResult =
        customRestExceptionHandler.handleAll(new Exception("foo"));
    assertEquals("500", ((ErrorResponseDto) actualHandleAllResult.getBody()).getCode());
    assertEquals(
        "Error occurred, check required fields or contact with the API Administrator",
        ((ErrorResponseDto) actualHandleAllResult.getBody()).getMessage());
    assertEquals(500, actualHandleAllResult.getStatusCodeValue());
    assertTrue(actualHandleAllResult.hasBody());
    assertTrue(actualHandleAllResult.getHeaders().isEmpty());
  }

  @Test
  void testHandleNotFoundException() {
    ResponseEntity<Object> actualHandleNotFoundExceptionResult =
        customRestExceptionHandler.handleNotFoundException(new PriceNotFoundException());
    assertEquals(
        "400", ((ErrorResponseDto) actualHandleNotFoundExceptionResult.getBody()).getCode());
    assertEquals(
        "Product or price not found",
        ((ErrorResponseDto) actualHandleNotFoundExceptionResult.getBody()).getMessage());
    assertEquals(400, actualHandleNotFoundExceptionResult.getStatusCodeValue());
    assertTrue(actualHandleNotFoundExceptionResult.hasBody());
    assertTrue(actualHandleNotFoundExceptionResult.getHeaders().isEmpty());
  }
}
