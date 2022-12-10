package org.healthplus.supports;

import org.healthplus.account.domain.RegisterCompletedEvent;
import org.healthplus.model.domain.DomainEvent;
import org.healthplus.model.domain.EventPublisher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class DomainEventTranslator implements EventPublisher {
  private final ApplicationEventPublisher applicationEventPublisher;

  public DomainEventTranslator(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }

  @Override
  public void publish(DomainEvent event) {
    applicationEventPublisher.publishEvent(event);
  }

  /*
  * 인스턴스 생성은 하지만 다른 컨텍스트에서 활용할 수 없음
  * */
  private void translate(RegisterCompletedEvent event) {
    org.healthplus.notification.account.RegisterCompletedEvent.eventNotifyFromAccount(
        event.getName(),
        event.getEmail(),
        event.getPhoneNumber(),
        event.getRole()
    );
  }
}
