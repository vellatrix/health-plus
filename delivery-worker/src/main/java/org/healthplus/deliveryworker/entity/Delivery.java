package org.healthplus.deliveryworker.entity;

import lombok.*;
import org.healthplus.model.entity.Address;

import javax.persistence.*;

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

    @Embedded
    private Address address;

    @Builder
    public Delivery(Long deliveryId, Long orderId, Long driverId, Address address) {
        this.deliveryId = deliveryId;
        this.orderId = orderId;
        this.driverId = driverId;
        this.address = address;
    }
}
