package org.healthplus.deliveryworker.service;

import org.healthplus.deliveryworker.presentation.requestDto.DeliverySignUpInfoDto;
import org.healthplus.deliveryworker.service.dto.requestDto.DeliveryDriverControllerToServiceDto;

public interface DeliveryDriverService {

  String signUpCommand(DeliveryDriverControllerToServiceDto deliveryDriverControllerToServiceDto);

}
