package org.healthplus.vendor.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.healthplus.vendor.enums.IsYn;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@ToString
@Entity
@Table(name = "vendor")
@NoArgsConstructor
public class Vendor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "vendor_id")
  private Long vendorId;

  @Column(name = "account_number")
  private String accountNumber;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Enumerated(EnumType.STRING)
  @Column(name = "use_yn")
  private IsYn useYn;

  @Column(name = "create_dt")
  private LocalDateTime createdAt;

  @Column(name = "modify_dt")
  private LocalDateTime modifiedAt;

  @Column(name = "delete_dt")
  private LocalDateTime deletedAt;

  @Column(name = "id")
  private String id;

  @Column(name = "password")
  private String password;

  @Column(name = "email")
  private String email;

  @Column(name = "name")
  private String name;

  @Column(name = "bank")
  private String bank;

  @Builder
  public Vendor(Long vendorId,
                String accountNumber,
                String phoneNumber,
                IsYn useYn,
                LocalDateTime deletedAt,
                String id,
                String password,
                String email,
                String name,
                String bank) {
    this.vendorId = vendorId;
    this.accountNumber = accountNumber;
    this.phoneNumber = phoneNumber;
    this.useYn = useYn;
    this.createdAt = LocalDateTime.now();
    this.deletedAt = deletedAt;
    this.id = id;
    this.password = password;
    this.email = email;
    this.name = name;
    this.bank = bank;
    this.useYn = IsYn.Y;
  }
}
