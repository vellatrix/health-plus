package org.healthplus.user.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.healthplus.model.role.Role;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long userId;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "nick", nullable = false)
  private String nickName;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "phone_number", nullable = false)
  private String phoneNumber;

  @Column(name = "role")
  private Role role;

  public User(String email, String nickName, String password, String phoneNumber) {
    this.email = email;
    this.nickName = nickName;
    this.password = password;
    this.phoneNumber = phoneNumber;
  }

  public User() {
  }
}
