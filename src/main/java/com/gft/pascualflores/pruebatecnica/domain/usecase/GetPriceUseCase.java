package com.gft.pascualflores.pruebatecnica.domain.usecase;

import com.gft.pascualflores.pruebatecnica.domain.model.PriceDto;
import java.time.OffsetDateTime;

public interface GetPriceUseCase {

  PriceDto getPriceByDateAndPriceIdAndBrandId(OffsetDateTime date, Long productId, Long brandId);
}
