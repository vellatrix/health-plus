package org.healthplus.deliveryworker.service;

import org.healthplus.deliveryworker.enums.Result;
import org.healthplus.deliveryworker.presentation.responseDto.DeliveryDriverProfileDTO;
import org.healthplus.deliveryworker.presentation.responseDto.DeliveryDriverRegistrationResultDTO;
import org.healthplus.deliveryworker.service.command.DeliveryDriverInfoCommand;

public interface DeliveryDriverService {

  DeliveryDriverRegistrationResultDTO registerDriver(DeliveryDriverInfoCommand deliveryDriverInfoCommand);

  DeliveryDriverProfileDTO getDriverProfile(Long id);

  Result removeDriver(Long driverId);
}
