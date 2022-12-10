package org.healthplus.model.domain;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public abstract class DomainEvent {
  private final Instant occurredOn = Instant.now();

  public Instant getOccurredOn() {
    return this.occurredOn;
  }
}

