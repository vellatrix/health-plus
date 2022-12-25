package org.healthplus.order.domain.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.healthplus.model.domain.DomainEvent;

@Getter
@AllArgsConstructor
public class OrderCanceledEvent extends DomainEvent {

  private Long orderId;
}