package org.healthplus.deliveryworker.entity;

import lombok.*;
import javax.persistence.*;
import org.springframework.lang.Nullable;
import org.healthplus.model.entity.Address;


@Entity
@Table(name = "delivery")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Delivery {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "delivery_id")
  private Long deliveryId;

  @Column(name = "order_id")
  private Long orderId;

  @Column(name = "driver_id")
  private Long driverId;

  @Column(name = "city")
  private String city;
  @Column(name = "street")
  private String street;
  @Column(name = "zip_code")
  @Nullable
  private Integer zipCode;

  @Builder
  public Delivery(Long deliveryId, Long orderId, Long driverId, String city, String street,
      @Nullable Integer zipCode) {
    this.deliveryId = deliveryId;
    this.orderId = orderId;
    this.driverId = driverId;
    this.city = city;
    this.street = street;
    this.zipCode = zipCode;
  }
}
