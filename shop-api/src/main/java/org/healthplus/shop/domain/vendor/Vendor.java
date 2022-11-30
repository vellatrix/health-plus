package org.healthplus.shop.domain.vendor;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.shop.domain.shop.Shop;
import org.healthplus.shop.domain.shop.enums.IsYn;

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
import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "vendor")
@Getter
public class Vendor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "vendor_id")
  private Long id;

  private String nickName;
  private String email;
  private String phoneNumber;
  private String name;
  private String password;

  @Embedded
  private Bank bank;

  @Embedded
  private UserId userId;

  @Column(name = "create_dt")
  private LocalDateTime createdAt;

  @Column(name = "modify_dt")
  private LocalDateTime modifiedAt;

  @Column(name = "delete_dt")
  private LocalDateTime deletedAt;

  @Enumerated(EnumType.STRING)
  private IsYn useYn;

  @Builder
  public Vendor(String nickName,
                String email,
                String phoneNumber,
                String name,
                String password,
                UserId userId) {
    this.nickName = nickName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.name = name;
    this.password = password;
    this.userId = userId;
  }

  public Vendor(Long id, String nickName, String email) {
    this.id = id;
    this.nickName = nickName;
    this.email = email;
  }

  public void changeVendorData(Vendor from) {
    this.nickName = from.nickName;
    this.email = from.email;
  }

}
