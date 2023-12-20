package com.gft.pascualflores.pruebatecnica.infrastructure.mapper;

import com.gft.pascualflores.pruebatecnica.domain.model.PriceDto;
import com.gft.pascualflores.pruebatecnica.infrastructure.entity.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PriceMapper {

  @Mapping(target = "productId", source = "product.id")
  @Mapping(target = "brandId", source = "brand.id")
  @Mapping(target = "priceList", source = "priceList.id")
  PriceDto priceToPriceDto(Price price);
}
