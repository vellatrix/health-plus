package org.healthplus.deliveryworker.service.impl;

import lombok.RequiredArgsConstructor;
import org.healthplus.deliveryworker.repository.DeliveryDriverRepository;
import org.healthplus.deliveryworker.repository.DeliveryRepository;
import org.healthplus.deliveryworker.service.DeliveryService;
import org.healthplus.deliveryworker.service.command.DeliveryInfoCommand;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

  private final DeliveryRepository deliveryRepository;
  private final DeliveryDriverRepository deliveryDriverRepository;

  @Override
  public void getDeliveryInfo(DeliveryInfoCommand deliveryInfoCommand) {
  }
}
