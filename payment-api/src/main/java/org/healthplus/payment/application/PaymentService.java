package org.healthplus.payment.application;

import lombok.RequiredArgsConstructor;
import org.healthplus.payment.application.config.PaymentRestTemplateConfig;
import org.healthplus.payment.domain.Payment;
import org.healthplus.payment.infrastructure.JpaPaymentRepository;
import org.healthplus.payment.presentation.PaymentRequest;
import org.healthplus.payment.presentation.PaymentResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

  private final JpaPaymentRepository paymentRepository;
  private final PaymentRestTemplateConfig restTemplateConfig;
  private static final String ORDER_PREFIX = "hp_";
  private static final String CALL_BACK_URL = "http://localhost:8080";

  @Transactional
  public boolean payOrder(PaymentRequest dto) {

    TossPaymentRequest tossPaymentRequest = TossPaymentRequest.builder()
            .orderId(ORDER_PREFIX + UUID.randomUUID().toString().replace("-", ""))
            .amount(dto.getAmount())
            .successUrl(CALL_BACK_URL)
            .failUrl(CALL_BACK_URL)
            .orderName(dto.getItemName())
            .method("카드")
            .build();

    PaymentResponse paymentResponse = restTemplateConfig.restTemplateForPayment()
            .postForEntity("PG사_URL", dto, PaymentResponse.class)
            .getBody();

    boolean result = paymentResponse.isStatus();

    if(result) {
      Payment payment = Payment.of(dto, paymentResponse);
      paymentRepository.save(payment);
      return true;
    }
    else {
      return false;
    }
  }
}
