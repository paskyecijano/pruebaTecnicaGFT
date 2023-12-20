package com.gft.pascualflores.pruebatecnica.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;

import com.gft.pascualflores.pruebatecnica.infrastructure.mapper.PriceMapper;
import com.gft.pascualflores.pruebatecnica.infrastructure.repository.InH2PriceRepository;
import com.gft.pascualflores.pruebatecnica.infrastructure.repository.PriceRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PriceRepositoryImpl.class})
@ExtendWith(SpringExtension.class)
class PriceRepositoryImplTest {
  @MockBean private InH2PriceRepository inH2PriceRepository;

  @Autowired private PriceRepositoryImpl priceRepositoryImpl;

  @MockBean private PriceMapper priceMapper;

  @Test
  void given_mocked_data_when_call_getPriceByDateAndPriceIdAndBrandId_then_return_value() {
    when(inH2PriceRepository.getPrice((OffsetDateTime) any(), (Long) any(), (Long) any()))
        .thenReturn(new ArrayList<>());
    assertFalse(priceRepositoryImpl.getPriceByDateAndPriceIdAndBrandId(null, 1L, 1L).isPresent());
    verify(inH2PriceRepository).getPrice((OffsetDateTime) any(), (Long) any(), (Long) any());
  }
}
