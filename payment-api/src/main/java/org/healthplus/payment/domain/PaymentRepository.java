package org.healthplus.payment.domain;

import java.util.Optional;

public interface PaymentRepository {

  void save(Payment payment);

  Optional<Payment> findByOrderId(Long orderId);
}
