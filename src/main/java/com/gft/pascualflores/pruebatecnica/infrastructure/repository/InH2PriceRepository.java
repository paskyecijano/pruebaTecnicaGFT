package com.gft.pascualflores.pruebatecnica.infrastructure.repository;

import com.gft.pascualflores.pruebatecnica.infrastructure.entity.Price;
import java.time.OffsetDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InH2PriceRepository extends JpaRepository<Price, Long> {

  @Query(
      value =
          "SELECT TOP 1 * FROM prices p WHERE :date >= p.start_date and :date <= p.end_date and p.product_id = :productId and p.brand_id = :brandId order by priority desc",
      nativeQuery = true)
  Price getPrice(
      @Param("date") OffsetDateTime date,
      @Param("productId") Long productId,
      @Param("brandId") Long brandId);
}
