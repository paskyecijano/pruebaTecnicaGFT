package com.gft.pascualflores.pruebatecnica.apirest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PriceNotFoundException extends Exception {

  public PriceNotFoundException() {}
}
