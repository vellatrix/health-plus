package org.healthplus.deliveryworker.repository.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.healthplus.deliveryworker.entity.DeliveryDriver;
import org.healthplus.deliveryworker.repository.DeliveryDriverRepository;
import org.healthplus.deliveryworker.repository.JpaDeliveryDriverRepository;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
public class DeliveryDriverRepositoryImpl implements DeliveryDriverRepository {

  private final JpaDeliveryDriverRepository driverRepository;
  @Override
  public DeliveryDriver save(DeliveryDriver deliveryDriver) {
    log.info("deliveryDriver = {}", deliveryDriver);
    return driverRepository.save(deliveryDriver);
  }
}
