package org.healthplus.deliveryworker.repository;

import org.healthplus.deliveryworker.entity.DeliveryDriver;


public interface DeliveryDriverRepository {

  DeliveryDriver save(DeliveryDriver deliveryDriver);

  DeliveryDriver findDriver(Long driverId);

  void deleteById(Long driverId);
}
