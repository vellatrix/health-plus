package org.healthplus.deliveryworker.service;

import org.healthplus.deliveryworker.service.command.DeliveryInfoCommand;

public interface DeliveryService {

  void getDeliveryInfo(DeliveryInfoCommand deliveryInfoCommand);
}
