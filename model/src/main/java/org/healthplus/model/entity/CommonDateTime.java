package org.healthplus.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommonDateTime {

  @Column(name = "create_dt")
  private LocalDateTime createdAt;

  @Column(name = "modify_dt")
  private LocalDateTime modifiedAt;

  public CommonDateTime(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }


}
