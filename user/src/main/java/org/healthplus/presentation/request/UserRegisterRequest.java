package org.healthplus.presentation.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRegisterRequest {

  private String id;

  private String name;

  private String email;

  private String password;

  private String phoneNumber;
}
