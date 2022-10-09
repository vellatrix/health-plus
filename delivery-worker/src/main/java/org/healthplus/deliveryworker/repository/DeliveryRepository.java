package org.healthplus.deliveryworker.repository;

import org.healthplus.deliveryworker.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}
