package org.healthplus.order.domain.entity;

import lombok.Builder;
import lombok.Getter;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Entity
public class OrderOptionGroup {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_option_group_id")
  private Long id;

  private String name;

  @JoinColumn(name = "order_option_group_id")
  @OneToMany(cascade = CascadeType.ALL)
  private List<OrderOption> orderOptions;

  public OrderOptionGroup(String name, List<OrderOption> orderOptions) {
    this.name = name;
    this.orderOptions = orderOptions;
  }

  public Integer calculateEachItemPrice() {
    return orderOptions.stream()
            .mapToInt(OrderOption::getPrice)
            .sum();
  }
}