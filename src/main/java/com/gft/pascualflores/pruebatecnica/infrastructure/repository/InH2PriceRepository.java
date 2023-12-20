package com.gft.pascualflores.pruebatecnica.infrastructure.repository;

import com.gft.pascualflores.pruebatecnica.infrastructure.entity.Price;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InH2PriceRepository extends JpaRepository<Price, Long> {

  @EntityGraph("get-price-entity-graph")
  @Query(
      "SELECT p FROM Price p WHERE :date >= p.startDate and :date <= p.endDate and p.product.id = :productId and p.brand.id = :brandId")
  List<Price> getPrice(
      @Param("date") OffsetDateTime date,
      @Param("productId") Long productId,
      @Param("brandId") Long brandId);
}
