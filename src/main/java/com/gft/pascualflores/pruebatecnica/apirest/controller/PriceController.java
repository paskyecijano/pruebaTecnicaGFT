package com.gft.pascualflores.pruebatecnica.apirest.controller;

import com.gft.pascualflores.pruebatecnica.apirest.data.ResponsePriceDto;
import com.gft.pascualflores.pruebatecnica.apirest.exception.PriceNotFoundException;
import com.gft.pascualflores.pruebatecnica.apirest.mapper.ApiMapper;
import com.gft.pascualflores.pruebatecnica.domain.model.PriceDto;
import com.gft.pascualflores.pruebatecnica.domain.usecase.GetPriceUseCase;
import java.time.OffsetDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PriceController implements ApiApi {

  private final GetPriceUseCase getPriceUseCase;
  private final ApiMapper mapper;

  @Override
  public ResponseEntity<ResponsePriceDto> _getPrice(
      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime date,
      Long productId,
      Long brandId)
      throws PriceNotFoundException {
    PriceDto priceDto =
        getPriceUseCase.getPriceByDateAndPriceIdAndBrandId(date, productId, brandId);
    return ResponseEntity.ok(this.mapper.priceDtoToResponsePriceDto(priceDto));
  }
}
