package com.gft.pascualflores.pruebatecnica.apirest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import com.gft.pascualflores.pruebatecnica.apirest.data.ResponsePriceDto;
import com.gft.pascualflores.pruebatecnica.apirest.mapper.ApiMapper;
import com.gft.pascualflores.pruebatecnica.domain.exception.PriceNotFoundException;
import com.gft.pascualflores.pruebatecnica.domain.model.PriceDto;
import com.gft.pascualflores.pruebatecnica.domain.usecase.GetPriceUseCase;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PriceController.class})
@ExtendWith(SpringExtension.class)
class PriceControllerTest {
  @MockBean private ApiMapper apiMapper;

  @MockBean private GetPriceUseCase getPriceUseCase;

  @Autowired private PriceController priceController;

  @Test
  void given_date_priceId_and_brandId_when_call_endpoint_then_return_price()
      throws PriceNotFoundException {
    when(getPriceUseCase.getPriceByDateAndPriceIdAndBrandId(
            (OffsetDateTime) any(), (Long) any(), (Long) any()))
        .thenReturn(new PriceDto());
    when(apiMapper.priceDtoToResponsePriceDto((PriceDto) any())).thenReturn(new ResponsePriceDto());
    ResponseEntity<ResponsePriceDto> actual_getPriceResult =
        priceController._getPrice(null, 1L, 1L);
    assertTrue(actual_getPriceResult.hasBody());
    assertTrue(actual_getPriceResult.getHeaders().isEmpty());
    assertEquals(200, actual_getPriceResult.getStatusCodeValue());
    verify(getPriceUseCase)
        .getPriceByDateAndPriceIdAndBrandId((OffsetDateTime) any(), (Long) any(), (Long) any());
    verify(apiMapper).priceDtoToResponsePriceDto((PriceDto) any());
  }
}
