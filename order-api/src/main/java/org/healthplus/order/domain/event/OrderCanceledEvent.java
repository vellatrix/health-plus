package org.healthplus.order.domain.event;

import lombok.Getter;
import org.healthplus.model.domain.DomainEvent;

@Getter
public class OrderCanceledEvent extends DomainEvent {

  private Long orderId;
}
