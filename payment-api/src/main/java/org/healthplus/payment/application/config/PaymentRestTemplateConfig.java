package org.healthplus.payment.application.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class PaymentRestTemplateConfig {

  @Bean
  public RestTemplate restTemplateForPayment() {
    return new RestTemplateBuilder()
            .setConnectTimeout(Duration.ofSeconds(3))
            .setReadTimeout(Duration.ofSeconds(3))
            .additionalInterceptors(clientHttpRequestInterceptor())
            .build();
  }

  public ClientHttpRequestInterceptor clientHttpRequestInterceptor() {
    return (request, body, execution) -> {
      RetryTemplate retryTemplate = new RetryTemplate();
      retryTemplate.setRetryPolicy(new SimpleRetryPolicy(3));
      try {
        return retryTemplate.execute(context -> execution.execute(request, body));
      } catch (Throwable throwable) {
        throw new RuntimeException(throwable);
      }
    };
  }
}
