package org.healthplus.deliveryworker.repository;

import org.healthplus.deliveryworker.entity.DeliveryDriver;
import org.healthplus.deliveryworker.repository.impl.DeliveryDriverRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DeliveryDriverJpaRepository extends JpaRepository<DeliveryDriver, Long> {

  DeliveryDriver save(DeliveryDriver deliveryDriver);

}
