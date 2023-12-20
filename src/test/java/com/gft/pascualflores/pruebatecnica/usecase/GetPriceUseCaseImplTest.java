package com.gft.pascualflores.pruebatecnica.usecase;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import com.gft.pascualflores.pruebatecnica.application.usecase.GetPriceUseCaseImpl;
import com.gft.pascualflores.pruebatecnica.domain.exception.PriceNotFoundException;
import com.gft.pascualflores.pruebatecnica.domain.model.PriceDto;
import com.gft.pascualflores.pruebatecnica.domain.repository.PriceRepository;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {GetPriceUseCaseImpl.class})
@ExtendWith(SpringExtension.class)
class GetPriceUseCaseImplTest {
  @Autowired private GetPriceUseCaseImpl getPriceUseCaseImpl;

  @MockBean private PriceRepository priceRepository;

  @Test
  void given_mocked_data_when_call_getPriceByDateAndPriceIdAndBrandId_then_return_price()
      throws PriceNotFoundException {
    PriceDto priceDto = new PriceDto();
    when(priceRepository.getPriceByDateAndPriceIdAndBrandId(
            (OffsetDateTime) any(), (Long) any(), (Long) any()))
        .thenReturn(Optional.of(priceDto));
    assertSame(priceDto, getPriceUseCaseImpl.getPriceByDateAndPriceIdAndBrandId(null, 1L, 1L));
    verify(priceRepository)
        .getPriceByDateAndPriceIdAndBrandId((OffsetDateTime) any(), (Long) any(), (Long) any());
  }

  @Test
  void given_wrong_data_when_call_getPriceByDateAndPriceIdAndBrandId_then_throws_exception()
      throws PriceNotFoundException {
    when(priceRepository.getPriceByDateAndPriceIdAndBrandId(
            (OffsetDateTime) any(), (Long) any(), (Long) any()))
        .thenReturn(Optional.empty());
    assertThrows(
        PriceNotFoundException.class,
        () -> getPriceUseCaseImpl.getPriceByDateAndPriceIdAndBrandId(null, 1L, 1L));
    verify(priceRepository)
        .getPriceByDateAndPriceIdAndBrandId((OffsetDateTime) any(), (Long) any(), (Long) any());
  }
}
