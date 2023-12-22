package com.gft.pascualflores.pruebatecnica.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

import com.gft.pascualflores.pruebatecnica.infrastructure.entity.Price;
import com.gft.pascualflores.pruebatecnica.infrastructure.mapper.PriceMapper;
import com.gft.pascualflores.pruebatecnica.infrastructure.repository.InH2PriceRepository;
import com.gft.pascualflores.pruebatecnica.infrastructure.repository.PriceRepositoryImpl;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PriceRepositoryImplTest {

  public static final long PRODUCT_ID = 35455L;
  public static final long BRAND_ID = 1L;
  @Mock private InH2PriceRepository inH2PriceRepository;

  @Mock private PriceMapper priceMapper;

  @InjectMocks private PriceRepositoryImpl priceRepositoryImpl;

  @Test
  void given_mocked_data_when_call_getPriceByDateAndPriceIdAndBrandId_then_return_value() {
    OffsetDateTime myDate = OffsetDateTime.now();

    when(inH2PriceRepository.getPrice(myDate, PRODUCT_ID, BRAND_ID)).thenReturn(new Price());
    assertFalse(
        priceRepositoryImpl
            .getPriceByDateAndPriceIdAndBrandId(myDate, PRODUCT_ID, BRAND_ID)
            .isPresent());
    verify(inH2PriceRepository).getPrice(myDate, PRODUCT_ID, BRAND_ID);
  }
}
