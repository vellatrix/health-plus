package org.healthplus.deliveryworker.service.impl;

import static org.healthplus.deliveryworker.exception.ErrorCode.DELIVERY_REMOVAL_FAIL;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.healthplus.deliveryworker.enums.Result;
import org.healthplus.deliveryworker.exception.DeliveryWorkerException;
import org.healthplus.deliveryworker.presentation.responseDto.DeliveryDriverProfileDTO;
import org.healthplus.deliveryworker.presentation.responseDto.DeliveryDriverRegistrationResultDTO;
import org.healthplus.deliveryworker.repository.DeliveryDriverRepository;
import org.healthplus.deliveryworker.service.DeliveryDriverService;
import org.healthplus.deliveryworker.service.command.DeliveryInfoCommand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeliveryDriverServiceImpl implements DeliveryDriverService {

  private final DeliveryDriverRepository deliveryDriverRepository;

  @Override
  public DeliveryDriverRegistrationResultDTO registerDriver(
      DeliveryInfoCommand deliveryInfoCommand) {
    return DeliveryDriverRegistrationResultDTO.addDriverResult(
        deliveryDriverRepository.save(deliveryInfoCommand.toEntity()));
  }

  @Override
  public DeliveryDriverProfileDTO getDriverProfile(Long driverId) {
    return DeliveryDriverProfileDTO.setProfile(deliveryDriverRepository.findDriver(driverId));
  }

  @Transactional(isolation = Isolation.SERIALIZABLE)
  @Override
  public Result removeDriver(Long driverId) {
    try {
      deliveryDriverRepository.deleteById(driverId);
      return Result.SUCCESS;
    } catch (Exception e) {
      throw new DeliveryWorkerException(DELIVERY_REMOVAL_FAIL);
    }
  }
}
