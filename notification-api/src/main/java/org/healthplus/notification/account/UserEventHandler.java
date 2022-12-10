package org.healthplus.notification.account;

import javax.annotation.processing.Processor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserEventHandler {

  @EventListener
  public void handle(RegisterCompletedEvent event) {
    log.info("userEventHandler is working");
  }

}
