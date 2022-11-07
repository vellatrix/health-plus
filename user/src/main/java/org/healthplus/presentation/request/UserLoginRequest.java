package org.healthplus.presentation.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserLoginRequest {

  private String id;
  private String password;
}
