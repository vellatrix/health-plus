package org.healthplus.payment.domain;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.model.domain.AggregateRoot;
import org.healthplus.payment.presentation.PaymentRequest;
import org.healthplus.payment.presentation.PaymentResponse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
public class Payment extends AggregateRoot {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long payId;

  private Long orderId;
  private String pg;
  private String content;
  private String method;
  private Integer amount;

  @Column(name = "create_dt")
  private LocalDateTime createdAt;

  @Builder
  public Payment(Long orderId,
                 String pg,
                 String content,
                 String method,
                 Integer amount,
                 LocalDateTime createdAt) {
    this.orderId = orderId;
    this.pg = pg;
    this.content = content;
    this.method = method;
    this.amount = amount;
    this.createdAt = createdAt;
  }

  public static Payment of(PaymentRequest request, PaymentResponse response) {
    return Payment.builder()
            .orderId(request.getOrderId())
            .amount(request.getAmount())
            .pg(response.getPg())
            .content(response.getContent())
            .method(response.getMethod())
            .createdAt(response.getPaidAt())
            .build();
  }
}