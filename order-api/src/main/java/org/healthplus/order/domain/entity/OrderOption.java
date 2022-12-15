package org.healthplus.order.domain.entity;

import lombok.Builder;
import lombok.Getter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
public class OrderOption {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_option_id")
  private Long id;

  private String name;

  private Integer price;

  public OrderOption(String name, Integer price) {
    this.name = name;
    this.price = price;
  }
}