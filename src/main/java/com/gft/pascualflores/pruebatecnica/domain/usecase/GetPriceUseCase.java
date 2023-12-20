package com.gft.pascualflores.pruebatecnica.domain.usecase;

import com.gft.pascualflores.pruebatecnica.domain.exception.PriceNotFoundException;
import com.gft.pascualflores.pruebatecnica.domain.model.PriceDto;
import java.time.OffsetDateTime;

public interface GetPriceUseCase {

  PriceDto getPriceByDateAndProductIdAndBrandId(OffsetDateTime date, Long productId, Long brandId)
      throws PriceNotFoundException;
}
