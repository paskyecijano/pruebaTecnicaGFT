package com.gft.pascualflores.pruebatecnica.infrastructure.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prices")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraph(
    name = "get-price-entity-graph",
    attributeNodes = {
      @NamedAttributeNode("priceList"),
      @NamedAttributeNode("brand"),
      @NamedAttributeNode("product"),
    })
public class Price {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "start_date", nullable = false)
  private OffsetDateTime startDate;

  @Column(name = "end_date", nullable = false)
  private OffsetDateTime endDate;

  @Column(name = "curr", nullable = false)
  private String currency;

  @Column(nullable = false)
  private Integer priority;

  @Column(nullable = false)
  private Double price;

  @ManyToOne
  @JoinColumn(name = "price_list_id")
  private PriceList priceList;

  @ManyToOne
  @JoinColumn(name = "brand_id")
  private Brand brand;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;
}
