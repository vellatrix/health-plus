package org.healthplus.vendor.entity;

import lombok.Getter;
import lombok.ToString;
import org.healthplus.vendor.enums.IsYn;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@ToString
@Entity
@Table(name = "category")
public class Category {

  @Id
  @Column(name = "category_id")
  private Long categoryId;

  @Enumerated(EnumType.STRING)
  @Column(name = "use_yn")
  private IsYn useYn;

  @Column(name = "create_dt")
  private LocalDateTime createdAt;

  @Column(name = "modify_dt")
  private LocalDateTime modifiedAt;

  @Column(name = "type")
  private String type;
}
