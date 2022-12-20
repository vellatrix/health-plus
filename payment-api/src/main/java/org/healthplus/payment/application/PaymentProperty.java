package org.healthplus.payment.application;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "payment")
@Getter
@Component
public class PaymentProperty {

  private String key;
  private String url;
}
