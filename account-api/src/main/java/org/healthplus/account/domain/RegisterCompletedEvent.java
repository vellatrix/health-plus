package org.healthplus.account.domain;

import java.time.Instant;
import lombok.Getter;
import org.healthplus.model.domain.DomainEvent;
import org.healthplus.model.role.Role;


@Getter
public class RegisterCompletedEvent extends DomainEvent {

  private final String email;
  private final String name;
  private final String phoneNumber;
  private final Role role;
  private final Instant occurredOn;

  public RegisterCompletedEvent(User user) {
    this.email = user.getEmail();
    this.name = user.getName();
    this.phoneNumber = user.getPhoneNumber();
    this.role = user.getRole();
    this.occurredOn = getOccurredOn(); // getOccurredOn is in DomainEvent class
  }
}
