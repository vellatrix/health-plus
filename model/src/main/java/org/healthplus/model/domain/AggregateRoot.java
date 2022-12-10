package org.healthplus.model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
* Aggregate는 DomainEvent를 갖고 있습니다. 왜냐하면 최종적 일관성을 지키기 위함입니다.
* 해당 도메인 이벤트는 Domain 안에서 발생합니다.
* */
public abstract class AggregateRoot {

  private final List<DomainEvent> events = new ArrayList<>();

  public void raiseEvent(DomainEvent event) {
    this.events.add(event);
  }

  public List<DomainEvent> occurredEvents() {
    if (!events.isEmpty()) {
      List<DomainEvent> domainEvents = List.copyOf(this.events);
      this.events.clear();
      return domainEvents;
    } else {
      return Collections.emptyList();
    }
  }
}

