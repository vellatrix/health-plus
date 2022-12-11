package org.healthplus.order.domain.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "order_lines")
public class OrderLines {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_lines_id")
  private Long id;

  private Long orderId;
  private String name;
  private Integer price;
  private Integer quantity;

  @Column(name = "create_dt")
  private LocalDateTime createdAt;
}
