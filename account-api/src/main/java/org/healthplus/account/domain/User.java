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
import org.healthplus.model.domain.AggregateRoot;
import org.healthplus.model.role.Role;

@Entity
@NoArgsConstructor
@Table(name = "user")
@Getter
@ToString
public class User extends AggregateRoot {

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

  private User(String name, String password, String email, String phoneNumber, Role role) {
    this.name = name;
    this.password = password;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.role = role;
  }

  public static User register(String name, String password, String email, String phoneNumber,
      Role role) {
    User user = new User(name, password, email, phoneNumber, role);
    user.registerEvent();
    return user;
  }

  private void registerEvent() {
    raiseEvent(new RegisterCompletedEvent(this));
  }

  public void setId(Long userId) {
    id = userId;
  }

  /*
   * DomainEvent를 통해 일관성을 맞춘다.
   * */
  public void changeEmail(String email) {
    this.email = email;
    raiseEvent(new UserEmailChanged());
  }
}
