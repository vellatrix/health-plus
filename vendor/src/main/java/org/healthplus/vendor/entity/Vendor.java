package org.healthplus.vendor.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.healthplus.model.entity.CommonDateTime;
import org.healthplus.vendor.dto.VendorRegistrationDTO;
import org.healthplus.vendor.enums.IsYn;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@ToString
@Entity
@Table(name = "vendor")
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

  @Embedded
  private CommonDateTime timeManagement;

  @Column(name = "delete_dt")
  private LocalDateTime deletedAt;

  private String id;
  private String password;
  private String email;
  private String name;
  private String bank;

  public Vendor() {
  }

  @Builder
  public Vendor(Long vendorId,
                String accountNumber,
                String phoneNumber,
                IsYn useYn,
                CommonDateTime timeManagement,
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
    this.timeManagement = timeManagement;
    this.deletedAt = deletedAt;
    this.id = id;
    this.password = password;
    this.email = email;
    this.name = name;
    this.bank = bank;
    this.useYn = IsYn.Y;
  }
}
