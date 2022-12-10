package org.healthplus.supports;

import org.healthplus.account.domain.RegisterCompletedEvent;
import org.healthplus.model.domain.EventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AccountEventTranslator {

  private final EventPublisher eventPublisher;

  public AccountEventTranslator(EventPublisher eventPublisher) {
    this.eventPublisher = eventPublisher;
  }

  // TODO: 2022/12/10 EventListener 동작 과정 살피기
  // TransactionEventListener 차이 알아보기
  @EventListener
  public void handle(RegisterCompletedEvent event) {
    eventPublisher.publish(
        org.healthplus.notification.account.RegisterCompletedEvent.eventNotifyFromAccount(
            event.getName(),
            event.getEmail(),
            event.getPhoneNumber(),
            event.getRole()
        )
    );

  }


}
