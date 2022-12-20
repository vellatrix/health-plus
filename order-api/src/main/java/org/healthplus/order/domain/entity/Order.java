package org.healthplus.order.domain.entity;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.model.domain.AggregateRoot;
import org.healthplus.order.domain.event.OrderPayedEvent;
import org.healthplus.order.domain.exception.OrderPriceNotMatchedException;
import org.healthplus.order.domain.exception.OrderStatusDifferentialException;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
@Getter
public class Order extends AggregateRoot {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_id")
  private Long id;

  private Long customerId;
  private Long shopId;
  private Long riderId;
  private Integer deliveryFee;
  private Integer totalPrice;

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private OrderStatus orderStatus;

  @Embedded
  private Address address;

  @Column(name = "create_dt")
  private LocalDateTime createdAt;
  @Column(name = "modify_dt")
  private LocalDateTime modifiedAt;

  @JoinColumn(name = "order_id")
  @OneToMany(cascade = CascadeType.ALL)
  private List<OrderLines> orderLines = new ArrayList<>();

  @Builder
  public Order(Long customerId,
               Long shopId,
               Long riderId,
               Integer totalPrice,
               Integer deliveryFee,
               Address address,
               List<OrderLines> orderLines) {
    this.customerId = customerId;
    this.shopId = shopId;
    this.riderId = riderId;
    this.totalPrice = totalPrice;
    this.deliveryFee = deliveryFee;
    this.address = address;
    this.orderLines = orderLines;
    this.createdAt = LocalDateTime.now();
  }

  public void changeStatus() {
    this.orderStatus = OrderStatus.ORDERED;
  }

  public Integer calculateTotalPrice() {
    this.totalPrice = this.orderLines.stream()
            .mapToInt(OrderLines::calculateTotalPrice)
            .sum() + this.deliveryFee;

    return this.totalPrice;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Order order = (Order) o;
    return Objects.equals(id, order.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public void cancelOrder() {

  }

  public void payOrder(Integer currentPrice) {
    if(this.totalPrice != currentPrice) throw new OrderPriceNotMatchedException();
    if(this.orderStatus != OrderStatus.ORDERED) throw new OrderStatusDifferentialException();

    this.orderStatus = OrderStatus.PAYED;
    raiseEvent(new OrderPayedEvent(id, totalPrice));
  }
}
