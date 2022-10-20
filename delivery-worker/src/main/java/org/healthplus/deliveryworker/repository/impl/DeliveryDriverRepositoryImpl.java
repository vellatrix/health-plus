package org.healthplus.deliveryworker.repository.impl;

import static org.healthplus.deliveryworker.exception.ErrorCode.INVALID_DELIVERY_WORKER;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.healthplus.deliveryworker.entity.DeliveryDriver;
import org.healthplus.deliveryworker.enums.Result;
import org.healthplus.deliveryworker.exception.DeliveryWorkerException;
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
    return driverRepository.save(deliveryDriver);
  }

  @Override
  public DeliveryDriver findDriver(Long driverId) {
    return driverRepository.findById(driverId).orElseThrow(() -> new DeliveryWorkerException(INVALID_DELIVERY_WORKER));
  }

  @Override
  public void deleteById(Long driverId) {
    driverRepository.deleteById(driverId);
  }
}
