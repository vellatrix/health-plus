package org.healthplus.deliveryworker.repository.impl;

import lombok.RequiredArgsConstructor;
import org.healthplus.deliveryworker.repository.DeliveryRepository;
import org.healthplus.deliveryworker.repository.JpaDeliveryRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DeliveryRepositoryImpl implements DeliveryRepository {

  private final JpaDeliveryRepository jpaDeliveryRepository;

}
