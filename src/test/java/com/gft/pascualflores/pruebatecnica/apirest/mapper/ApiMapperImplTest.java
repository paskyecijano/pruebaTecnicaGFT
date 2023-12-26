package com.gft.pascualflores.pruebatecnica.apirest.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.gft.pascualflores.pruebatecnica.apirest.data.ResponsePriceDto;
import com.gft.pascualflores.pruebatecnica.domain.model.PriceDto;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ApiMapperImpl.class})
@ExtendWith(SpringExtension.class)
class ApiMapperImplTest {
  @Autowired private ApiMapperImpl apiMapperImpl;

  @Test
  void testPriceDtoToResponsePriceDto() {
    ResponsePriceDto actualPriceDtoToResponsePriceDtoResult =
        apiMapperImpl.priceDtoToResponsePriceDto(new PriceDto());
    assertNull(actualPriceDtoToResponsePriceDtoResult.getPrice());
    assertNull(actualPriceDtoToResponsePriceDtoResult.getBrandId());
    assertNull(actualPriceDtoToResponsePriceDtoResult.getPriceList());
    assertNull(actualPriceDtoToResponsePriceDtoResult.getProductId());
    assertNull(actualPriceDtoToResponsePriceDtoResult.getEndDate());
    assertNull(actualPriceDtoToResponsePriceDtoResult.getStartDate());
  }

  @Test
  void testPriceDtoToResponsePriceDto2() {
    assertNull(apiMapperImpl.priceDtoToResponsePriceDto(null));
  }

  @Test
  void testPriceDtoToResponsePriceDto3() {
    TemporalAdjuster temporalAdjuster = mock(TemporalAdjuster.class);
    when(temporalAdjuster.adjustInto(Mockito.<Temporal>any()))
        .thenReturn(
            OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
    OffsetDateTime startDate =
        OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
    startDate.with(temporalAdjuster);

    PriceDto productDto = new PriceDto();
    productDto.setStartDate(startDate);
    ResponsePriceDto actualPriceDtoToResponsePriceDtoResult =
        apiMapperImpl.priceDtoToResponsePriceDto(productDto);
    verify(temporalAdjuster).adjustInto(Mockito.<Temporal>any());
    assertEquals("Z", actualPriceDtoToResponsePriceDtoResult.getStartDate().getOffset().toString());
    assertNull(actualPriceDtoToResponsePriceDtoResult.getPrice());
    assertNull(actualPriceDtoToResponsePriceDtoResult.getBrandId());
    assertNull(actualPriceDtoToResponsePriceDtoResult.getPriceList());
    assertNull(actualPriceDtoToResponsePriceDtoResult.getProductId());
    assertNull(actualPriceDtoToResponsePriceDtoResult.getEndDate());
  }
}
