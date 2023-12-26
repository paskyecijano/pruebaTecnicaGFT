package com.gft.pascualflores.pruebatecnica.apirest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import com.gft.pascualflores.pruebatecnica.apirest.data.ResponsePriceDto;
import com.gft.pascualflores.pruebatecnica.apirest.mapper.ApiMapper;
import com.gft.pascualflores.pruebatecnica.domain.model.PriceDto;
import com.gft.pascualflores.pruebatecnica.domain.usecase.GetPriceUseCase;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {

  public static final long PRODUCT_ID = 35455L;
  public static final long BRAND_ID = 1L;

  @Mock private ApiMapper apiMapper;

  @Mock private GetPriceUseCase getPriceUseCase;

  @InjectMocks private PriceController priceController;

  @Test
  void given_date_priceId_and_brandId_when_call_endpoint_then_return_price() {

    OffsetDateTime findDate = OffsetDateTime.parse("2020-06-14T01:00:00Z");

    PriceDto myPriceDto =
        PriceDto.builder()
            .productId(PRODUCT_ID)
            .brandId(BRAND_ID)
            .priceList(1L)
            .startDate(findDate)
            .endDate(findDate)
            .price(20.0)
            .build();

    ResponsePriceDto responsePriceDto = new ResponsePriceDto();
    responsePriceDto.productId(PRODUCT_ID);
    responsePriceDto.brandId(BRAND_ID);
    responsePriceDto.priceList(1L);
    responsePriceDto.startDate(findDate);
    responsePriceDto.endDate(findDate);
    responsePriceDto.price(20.0);

    when(getPriceUseCase.getPriceByDateAndPriceIdAndBrandId(findDate, PRODUCT_ID, BRAND_ID))
        .thenReturn(myPriceDto);
    when(apiMapper.priceDtoToResponsePriceDto(myPriceDto)).thenReturn(responsePriceDto);
    ResponseEntity<ResponsePriceDto> actual_getPriceResult =
        priceController._price(findDate, PRODUCT_ID, BRAND_ID);
    assertTrue(actual_getPriceResult.hasBody());
    assertTrue(actual_getPriceResult.getHeaders().isEmpty());
    assertEquals(200, actual_getPriceResult.getStatusCodeValue());
    verify(getPriceUseCase).getPriceByDateAndPriceIdAndBrandId(findDate, PRODUCT_ID, BRAND_ID);
    verify(apiMapper).priceDtoToResponsePriceDto(myPriceDto);
  }
}
