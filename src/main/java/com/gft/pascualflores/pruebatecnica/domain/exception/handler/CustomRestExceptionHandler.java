package com.gft.pascualflores.pruebatecnica.domain.exception.handler;

import com.gft.pascualflores.pruebatecnica.apirest.data.ErrorResponseDto;
import com.gft.pascualflores.pruebatecnica.domain.exception.PriceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@RequiredArgsConstructor
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleAll(final Exception exception) {
    ErrorResponseDto error = new ErrorResponseDto();
    error.setCode("500");
    error.setMessage("Error occurred, check required fields or contact with the API Administrator");
    return new ResponseEntity<Object>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(PriceNotFoundException.class)
  public ResponseEntity<Object> handleNotFoundException(PriceNotFoundException exception) {
    ErrorResponseDto error = new ErrorResponseDto();
    error.setCode("400");
    error.setMessage("Product or price not found");
    return new ResponseEntity<Object>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }
}
