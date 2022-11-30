package org.healthplus.user.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.healthplus.user.application.UserService;
import org.healthplus.user.presentation.request.SignInRequest;
import org.healthplus.user.presentation.request.SignUpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserAuthentication {

  private final UserService userService;

  /*
  * 회원 가입
  * */
  @PostMapping("/api/auth/user/signup")
  public String signup(@RequestBody SignUpRequest registerRequest) {
    log.info("signup");
    userService.signUp(registerRequest.getEmail(), registerRequest.getNickName(),
        registerRequest.getEmail(),
        registerRequest.getPassword(), registerRequest.getPhoneNumber());
    return "ok";
  }

  @GetMapping("/test")
  public String test() {
    return "OK";
  }

  /*
   * 회원 가입 확인
   * */
  @GetMapping("/api/auth/user/confirm")
  public void registerConfirm() {
  }

  /*
   * 회원 로그인
   * */
  @PostMapping("/api/auth/user/login")
  public void login(SignInRequest loginRequest) {
    userService.login(loginRequest.getEmail(), loginRequest.getPassword());
  }

  /*
  * refreshToken 재발급
  * */
  @PostMapping("/api/auth/user/reIssuance")
  public void reIssuance() {

  }
}
