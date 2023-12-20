package com.gft.pascualflores.pruebatecnica.domain.model;

import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceDto {

  private Long productId;
  private Long brandId;
  private Long priceList;
  private OffsetDateTime startDate;
  private OffsetDateTime endDate;
  private Double price;
}
