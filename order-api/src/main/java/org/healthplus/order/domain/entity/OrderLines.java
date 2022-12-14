package org.healthplus.order.domain.entity;

import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

  @JoinColumn(name = "order_lines_id")
  @OneToMany(cascade = CascadeType.ALL)
  private List<OrderOptionGroup> orderOptionGroups = new ArrayList<>();

  public OrderLines(String name, Integer price, Integer quantity, List<OrderOptionGroup> orderOptionGroups) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.orderOptionGroups = orderOptionGroups;
  }

  public Integer calculateTotalPrice() {
    this.price = this.orderOptionGroups.stream()
                  .mapToInt(OrderOptionGroup::calculateEachItemPrice)
                  .map(each -> each * quantity)
                  .sum();

    return this.price;
  }
}
