package com.gft.pascualflores.pruebatecnica.usecase;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import com.gft.pascualflores.pruebatecnica.apirest.exception.PriceNotFoundException;
import com.gft.pascualflores.pruebatecnica.application.usecase.GetPriceUseCaseImpl;
import com.gft.pascualflores.pruebatecnica.domain.model.PriceDto;
import com.gft.pascualflores.pruebatecnica.domain.repository.PriceRepository;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetPriceUseCaseImplTest {

  public static final long PRODUCT_ID = 35455L;
  public static final long BRAND_ID = 1L;

  @InjectMocks private GetPriceUseCaseImpl getPriceUseCaseImpl;

  @Mock private PriceRepository priceRepository;

  @Test
  void given_mocked_data_when_call_getPriceByDateAndPriceIdAndBrandId_then_return_price() {
    PriceDto priceDto = new PriceDto();
    OffsetDateTime myDate = OffsetDateTime.now();

    when(priceRepository.getPriceByDateAndPriceIdAndBrandId(myDate, PRODUCT_ID, BRAND_ID))
        .thenReturn(Optional.of(priceDto));
    assertSame(
        priceDto,
        getPriceUseCaseImpl.getPriceByDateAndPriceIdAndBrandId(myDate, PRODUCT_ID, BRAND_ID));
    verify(priceRepository).getPriceByDateAndPriceIdAndBrandId(myDate, PRODUCT_ID, BRAND_ID);
  }

  @Test
  void given_wrong_data_when_call_getPriceByDateAndPriceIdAndBrandId_then_throws_exception() {
    OffsetDateTime myDate = OffsetDateTime.now();
    when(priceRepository.getPriceByDateAndPriceIdAndBrandId(myDate, PRODUCT_ID, BRAND_ID))
        .thenReturn(Optional.empty());
    assertThrows(
        PriceNotFoundException.class,
        () -> getPriceUseCaseImpl.getPriceByDateAndPriceIdAndBrandId(myDate, PRODUCT_ID, BRAND_ID));
    verify(priceRepository).getPriceByDateAndPriceIdAndBrandId(myDate, PRODUCT_ID, BRAND_ID);
  }
}
