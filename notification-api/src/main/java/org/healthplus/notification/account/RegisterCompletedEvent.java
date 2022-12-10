package org.healthplus.notification.account;

import lombok.extern.slf4j.Slf4j;
import org.healthplus.model.domain.DomainEvent;
import org.healthplus.model.role.Role;

@Slf4j
public class RegisterCompletedEvent extends DomainEvent {

  private final String name;
  private final String email;
  private final String phoneNumber;
  private final Role role;

  private RegisterCompletedEvent(String name, String email, String phoneNumber, Role role) {
    this.name = name;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.role = role;
    log.info("Account Register Event Listener Notification Module Response");
  }

  public static RegisterCompletedEvent eventNotifyFromAccount(String name, String email,
      String phoneNumber, Role role) {
    return new RegisterCompletedEvent(name, email, phoneNumber, role);
  }
}
