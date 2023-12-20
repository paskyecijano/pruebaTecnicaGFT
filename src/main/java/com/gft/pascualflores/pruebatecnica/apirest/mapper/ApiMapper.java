package com.gft.pascualflores.pruebatecnica.apirest.mapper;

import com.gft.pascualflores.pruebatecnica.apirest.data.ResponsePriceDto;
import com.gft.pascualflores.pruebatecnica.domain.model.PriceDto;
import org.mapstruct.Mapper;

@Mapper
public interface ApiMapper {

  ResponsePriceDto productDtoToResponsePriceDto(PriceDto productDto);
}
