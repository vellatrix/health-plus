package org.healthplus.deliveryworker.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.healthplus.deliveryworker.repository.DeliveryDriverRepository;
import org.healthplus.deliveryworker.service.DeliveryDriverService;
import org.healthplus.deliveryworker.service.command.DeliveryInfoCommand;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeliveryDriverServiceImpl implements DeliveryDriverService {

  private final DeliveryDriverRepository deliveryDriverRepository;

  @Override
  public void driverSignUp(DeliveryInfoCommand deliveryInfoCommand) {
    log.info("deliveryDriverService = {}", deliveryInfoCommand.toString());
    deliveryDriverRepository.save(deliveryInfoCommand.toEntity());
  }
}
