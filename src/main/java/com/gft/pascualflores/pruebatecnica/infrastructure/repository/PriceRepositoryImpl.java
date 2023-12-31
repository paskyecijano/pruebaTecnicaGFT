package com.gft.pascualflores.pruebatecnica.infrastructure.repository;

import com.gft.pascualflores.pruebatecnica.domain.model.PriceDto;
import com.gft.pascualflores.pruebatecnica.domain.repository.PriceRepository;
import com.gft.pascualflores.pruebatecnica.infrastructure.entity.Price;
import com.gft.pascualflores.pruebatecnica.infrastructure.mapper.PriceMapper;
import java.time.OffsetDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class PriceRepositoryImpl implements PriceRepository {

  private final InH2PriceRepository priceRepository;

  private final PriceMapper priceMapper;

  @Override
  public Optional<PriceDto> getPriceByDateAndPriceIdAndBrandId(
      OffsetDateTime date, Long productId, Long brandId) {
    Price price = priceRepository.getPrice(date, productId, brandId);
    return Optional.ofNullable(this.priceMapper.priceToPriceDto(price));
  }
}
