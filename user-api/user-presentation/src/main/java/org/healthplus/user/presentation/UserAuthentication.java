package org.healthplus.user.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.user.application.UserService;
import org.healthplus.user.presentation.request.UserLoginRequest;
import org.healthplus.user.presentation.request.UserRegisterRequest;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserAuthentication implements UserAuthenticationSpecification {

  private final UserService userService;

  @Override
  public void register(UserRegisterRequest registerRequest) {
    userService.signUp(registerRequest.getId(), registerRequest.getName(),
        registerRequest.getEmail(),
        registerRequest.getPassword(), registerRequest.getPhoneNumber());
  }

  @Override
  public void registerConfirm() {

  }

  @Override
  public void login(UserLoginRequest loginRequest) {
    userService.login(loginRequest.getId(), loginRequest.getPassword());
  }

  @Override
  public void reIssuance() {

  }
}
