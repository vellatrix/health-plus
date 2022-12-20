package org.healthplus.order.domain.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.healthplus.model.domain.DomainEvent;

@Getter
@AllArgsConstructor
public class OrderPayedEvent extends DomainEvent {

  private Long orderId;
  private Integer amount;

}
