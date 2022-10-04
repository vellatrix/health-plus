package org.healthplus.vendor.entity;

import lombok.Getter;
import lombok.ToString;
import org.healthplus.model.entity.CommonDateTime;
import org.healthplus.vendor.enums.IsYn;

import javax.persistence.*;

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

  @Embedded
  private CommonDateTime commonDateTime;

  private String type;
}
