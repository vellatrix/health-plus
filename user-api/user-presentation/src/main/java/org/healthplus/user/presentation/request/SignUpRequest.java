package org.healthplus.user.presentation.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpRequest {

  @NotNull
  @Email
  private String email;

  @NotNull
  private String nickName;

  @NotNull
  @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
      message = "최소 8 자, 최소 하나의 문자 및 하나의 숫자를 입력해주세요.")
  private String password;

  @NotNull
  @Pattern(regexp = "^\\d{11}$", message = "'-'없이 숫자 11자리만 입력해주세요.")
  private String phoneNumber;
}
