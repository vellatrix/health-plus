package org.healthplus.account.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.healthplus.model.role.Role;

@Entity
@NoArgsConstructor
@Table(name = "user")
@Getter
@ToString
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long id;

  @Column(name = "password")
  private String password;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "roles")
  private Role role;

  public User(String name, String password, String email, String phoneNumber, Role role) {
    this.name = name;
    this.password = password;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.role = role;
  }

  public void setId(Long userId) {
    id = userId;
  }
}
