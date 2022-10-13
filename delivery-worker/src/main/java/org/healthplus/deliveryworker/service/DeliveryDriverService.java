package org.healthplus.deliveryworker.service;

import org.healthplus.deliveryworker.presentation.requestDto.DeliveryInfoDto;
import org.healthplus.deliveryworker.service.command.DeliveryInfoCommand;

public interface DeliveryDriverService {

  void driverSignUp(DeliveryInfoCommand deliveryInfoCommand);
}
