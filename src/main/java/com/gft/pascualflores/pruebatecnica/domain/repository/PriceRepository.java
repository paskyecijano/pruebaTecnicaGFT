package com.gft.pascualflores.pruebatecnica.domain.repository;

import com.gft.pascualflores.pruebatecnica.domain.model.PriceDto;
import java.time.OffsetDateTime;
import java.util.Optional;

public interface PriceRepository {

  Optional<PriceDto> getPriceByDateAndPriceIdAndBrandId(
      OffsetDateTime date, Long productId, Long brandId);
}
