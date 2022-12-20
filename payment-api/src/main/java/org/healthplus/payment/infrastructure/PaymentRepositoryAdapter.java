package org.healthplus.payment.infrastructure;

import lombok.RequiredArgsConstructor;
import org.healthplus.payment.domain.Payment;
import org.healthplus.payment.domain.PaymentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryAdapter implements PaymentRepository {

  private final JpaPaymentRepository jpaPaymentRepository;

  @Override
  public void save(Payment payment) {
    jpaPaymentRepository.save(payment);
  }

  @Override
  public Optional<Payment> findByOrderId(Long orderId) {
    return jpaPaymentRepository.findByOrderId(orderId);
  }
}
