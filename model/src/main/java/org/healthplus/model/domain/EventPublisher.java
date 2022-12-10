package org.healthplus.model.domain;

public interface EventPublisher {

  void publish(DomainEvent event);
}
