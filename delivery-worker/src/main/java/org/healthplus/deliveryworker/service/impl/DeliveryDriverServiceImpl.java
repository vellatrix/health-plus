package org.healthplus.deliveryworker.service.impl;

import lombok.RequiredArgsConstructor;
import org.healthplus.deliveryworker.entity.DeliveryDriver;
import org.healthplus.deliveryworker.presentation.requestDto.DeliverySignUpInfoDto;
import org.healthplus.deliveryworker.repository.DeliveryDriverJpaRepository;
import org.healthplus.deliveryworker.service.DeliveryDriverService;
import org.healthplus.deliveryworker.service.dto.requestDto.DeliveryDriverControllerToServiceDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryDriverServiceImpl implements DeliveryDriverService {

  private final DeliveryDriverJpaRepository deliveryDriverJpaRepository;

  @Override
  public String signUpCommand(
      DeliveryDriverControllerToServiceDto deliveryDriverControllerToServiceDto) {
    deliveryDriverJpaRepository.save(
        new DeliveryDriver(
            deliveryDriverControllerToServiceDto.
        ));
    return "signUp is OK";
  }
}
