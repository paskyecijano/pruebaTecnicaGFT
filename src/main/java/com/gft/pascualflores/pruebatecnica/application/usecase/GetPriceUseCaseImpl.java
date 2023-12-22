package com.gft.pascualflores.pruebatecnica.application.usecase;

import com.gft.pascualflores.pruebatecnica.apirest.exception.PriceNotFoundException;
import com.gft.pascualflores.pruebatecnica.domain.model.PriceDto;
import com.gft.pascualflores.pruebatecnica.domain.repository.PriceRepository;
import com.gft.pascualflores.pruebatecnica.domain.usecase.GetPriceUseCase;
import java.time.OffsetDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GetPriceUseCaseImpl implements GetPriceUseCase {

  private final PriceRepository priceRepository;

  @Override
  public PriceDto getPriceByDateAndPriceIdAndBrandId(
      OffsetDateTime date, Long productId, Long brandId) throws PriceNotFoundException {
    Optional<PriceDto> productDto =
        priceRepository.getPriceByDateAndPriceIdAndBrandId(date, productId, brandId);
    if (productDto.isEmpty()) {
      throw new PriceNotFoundException();
    } else {
      return productDto.get();
    }
  }
}
