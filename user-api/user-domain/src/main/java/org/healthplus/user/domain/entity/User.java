package org.healthplus.user.domain.entity;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

  @Column(name = "id", nullable = false)
  private String id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "email", nullable = false)
  private String email; // Email

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "phone_number", nullable = false)
  private String phoneNumber;

  @Column(name = "create_dt")
  private LocalDateTime createdAt;

  @Column(name = "modify_dt")
  private LocalDateTime modifiedAt;

  @Column(name = "delete_dt")
  private LocalDateTime deletedAt;

  @ElementCollection(fetch = FetchType.EAGER)
  @Column(name = "roles")
  private Set<Role> roles;

  public User(String id, String name, String email, String password, String phoneNumber,
      LocalDateTime createdAt) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.phoneNumber = phoneNumber;
    this.createdAt = createdAt;
  }

  public User() {

  }

  /*
  public void updateRoles() {
    this.roles.add(asd);
    this.validateRoles();
  }

  public void validateRoles() {
    this.roles.size() <= 1
  }
*/

}
