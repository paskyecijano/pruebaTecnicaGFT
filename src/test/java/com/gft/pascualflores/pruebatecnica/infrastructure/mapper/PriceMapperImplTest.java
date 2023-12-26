package com.gft.pascualflores.pruebatecnica.infrastructure.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.gft.pascualflores.pruebatecnica.domain.model.PriceDto;
import com.gft.pascualflores.pruebatecnica.infrastructure.entity.Brand;
import com.gft.pascualflores.pruebatecnica.infrastructure.entity.Price;
import com.gft.pascualflores.pruebatecnica.infrastructure.entity.PriceList;
import com.gft.pascualflores.pruebatecnica.infrastructure.entity.Product;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PriceMapperImplTest {
  @InjectMocks
  private PriceMapperImpl priceMapperImpl;

  @Test
  void testPriceToPriceDto() {
    Brand brand = new Brand();
    brand.setId(1L);
    brand.setName("Name");
    brand.setPrices(new ArrayList<>());

    PriceList priceList = new PriceList();
    priceList.setId(1L);
    priceList.setName("Name");
    priceList.setPrices(new ArrayList<>());

    Product product = new Product();
    product.setId(1L);
    product.setName("Name");
    product.setPrices(new ArrayList<>());

    Price price = new Price();
    price.setBrand(brand);
    price.setCurrency("GBP");
    price.setEndDate(
        OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
    price.setId(1L);
    price.setPrice(10.0d);
    price.setPriceList(priceList);
    price.setPriority(1);
    price.setProduct(product);
    price.setStartDate(
        OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
    PriceDto actualPriceToPriceDtoResult = priceMapperImpl.priceToPriceDto(price);
    assertEquals("Z", actualPriceToPriceDtoResult.getEndDate().getOffset().toString());
    assertEquals("Z", actualPriceToPriceDtoResult.getStartDate().getOffset().toString());
    assertEquals(10.0d, actualPriceToPriceDtoResult.getPrice().doubleValue());
    assertEquals(1L, actualPriceToPriceDtoResult.getBrandId().longValue());
    assertEquals(1L, actualPriceToPriceDtoResult.getPriceList().longValue());
    assertEquals(1L, actualPriceToPriceDtoResult.getProductId().longValue());
  }

  @Test
  void testPriceToPriceDto2() {
    Brand brand = new Brand();
    brand.setId(null);
    brand.setName("Name");
    brand.setPrices(new ArrayList<>());

    PriceList priceList = new PriceList();
    priceList.setId(1L);
    priceList.setName("Name");
    priceList.setPrices(new ArrayList<>());

    Product product = new Product();
    product.setId(1L);
    product.setName("Name");
    product.setPrices(new ArrayList<>());

    Price price = new Price();
    price.setBrand(brand);
    price.setCurrency("GBP");
    price.setEndDate(
        OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
    price.setId(1L);
    price.setPrice(10.0d);
    price.setPriceList(priceList);
    price.setPriority(1);
    price.setProduct(product);
    price.setStartDate(
        OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
    PriceDto actualPriceToPriceDtoResult = priceMapperImpl.priceToPriceDto(price);
    assertEquals("Z", actualPriceToPriceDtoResult.getEndDate().getOffset().toString());
    assertEquals("Z", actualPriceToPriceDtoResult.getStartDate().getOffset().toString());
    assertNull(actualPriceToPriceDtoResult.getBrandId());
    assertEquals(10.0d, actualPriceToPriceDtoResult.getPrice().doubleValue());
    assertEquals(1L, actualPriceToPriceDtoResult.getPriceList().longValue());
    assertEquals(1L, actualPriceToPriceDtoResult.getProductId().longValue());
  }

  @Test
  void testPriceToPriceDto3() {
    Brand brand = new Brand();
    brand.setId(1L);
    brand.setName("Name");
    brand.setPrices(new ArrayList<>());

    PriceList priceList = new PriceList();
    priceList.setId(null);
    priceList.setName("Name");
    priceList.setPrices(new ArrayList<>());

    Product product = new Product();
    product.setId(1L);
    product.setName("Name");
    product.setPrices(new ArrayList<>());

    Price price = new Price();
    price.setBrand(brand);
    price.setCurrency("GBP");
    price.setEndDate(
        OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
    price.setId(1L);
    price.setPrice(10.0d);
    price.setPriceList(priceList);
    price.setPriority(1);
    price.setProduct(product);
    price.setStartDate(
        OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
    PriceDto actualPriceToPriceDtoResult = priceMapperImpl.priceToPriceDto(price);
    assertEquals("Z", actualPriceToPriceDtoResult.getEndDate().getOffset().toString());
    assertEquals("Z", actualPriceToPriceDtoResult.getStartDate().getOffset().toString());
    assertNull(actualPriceToPriceDtoResult.getPriceList());
    assertEquals(10.0d, actualPriceToPriceDtoResult.getPrice().doubleValue());
    assertEquals(1L, actualPriceToPriceDtoResult.getBrandId().longValue());
    assertEquals(1L, actualPriceToPriceDtoResult.getProductId().longValue());
  }

  @Test
  void testPriceToPriceDto4() {
    Brand brand = new Brand();
    brand.setId(1L);
    brand.setName("Name");
    brand.setPrices(new ArrayList<>());

    PriceList priceList = new PriceList();
    priceList.setId(1L);
    priceList.setName("Name");
    priceList.setPrices(new ArrayList<>());

    Product product = new Product();
    product.setId(null);
    product.setName("Name");
    product.setPrices(new ArrayList<>());

    Price price = new Price();
    price.setBrand(brand);
    price.setCurrency("GBP");
    price.setEndDate(
        OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
    price.setId(1L);
    price.setPrice(10.0d);
    price.setPriceList(priceList);
    price.setPriority(1);
    price.setProduct(product);
    price.setStartDate(
        OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
    PriceDto actualPriceToPriceDtoResult = priceMapperImpl.priceToPriceDto(price);
    assertEquals("Z", actualPriceToPriceDtoResult.getEndDate().getOffset().toString());
    assertEquals("Z", actualPriceToPriceDtoResult.getStartDate().getOffset().toString());
    assertNull(actualPriceToPriceDtoResult.getProductId());
    assertEquals(10.0d, actualPriceToPriceDtoResult.getPrice().doubleValue());
    assertEquals(1L, actualPriceToPriceDtoResult.getBrandId().longValue());
    assertEquals(1L, actualPriceToPriceDtoResult.getPriceList().longValue());
  }
}
