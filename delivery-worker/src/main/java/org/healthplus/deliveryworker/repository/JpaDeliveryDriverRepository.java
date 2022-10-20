package org.healthplus.deliveryworker.repository;

import org.healthplus.deliveryworker.entity.DeliveryDriver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaDeliveryDriverRepository extends JpaRepository<DeliveryDriver, Long> {

}
