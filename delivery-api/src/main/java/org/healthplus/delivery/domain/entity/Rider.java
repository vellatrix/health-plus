package org.healthplus.delivery.domain.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.healthplus.delivery.domain.enums.IsYn;
import org.healthplus.model.domain.AggregateRoot;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "rider")
@Getter
public class Rider extends AggregateRoot {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "rider_id")
  private Long id;

  @Column(name = "user_id")
  private Long userId;

  @Embedded
  private Vehicle vehicle;

  @Column(name = "create_dt")
  private LocalDateTime createdAt;

  @Column(name = "modify_dt")
  private LocalDateTime modifiedAt;

  @Column(name = "delete_dt")
  private LocalDateTime deletedAt;

  @Enumerated(EnumType.STRING)
  private IsYn useYn;

  @OneToMany(mappedBy = "rider", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Delivery> deliveries = new ArrayList<>();

}
