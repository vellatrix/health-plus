package org.healthplus.account.presentation;

import javax.servlet.http.HttpServletRequest;
import org.healthplus.account.application.AccountService;
import org.healthplus.account.application.command.AuthorizationCommand;
import org.healthplus.account.application.result.AccountResult;
import org.healthplus.account.domain.Authorization;
import org.healthplus.account.presentation.request.UserSignInRequest;
import org.healthplus.account.presentation.request.UserSignUpRequest;
import org.healthplus.model.result.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/user/")
public class AccountController {

  private final AccountService accountService;
  private final Authorization authorization;

  public AccountController(AccountService accountService, Authorization authorization) {
    this.accountService = accountService;
    this.authorization = authorization;
  }

  @PostMapping("/signup")
  public ApiResponse signUp(@RequestBody UserSignUpRequest request) {
    AccountResult signupResult = accountService.signup(request.toCommand());
    return ApiResponse.success(signupResult);
  }

  @PostMapping("/signin")
  public ApiResponse signin(@RequestBody UserSignInRequest request) {
    AccountResult signinResult = accountService.signin(request.toCommand());
    String session = authorization.login(
        new AuthorizationCommand(signinResult.getId(), signinResult.getEmail(),
            signinResult.getRole()
        ));
    signinResult.addToken(session);
    return ApiResponse.success(signinResult);
  }

  @PostMapping("/jwt/signin")
  public ApiResponse signinJwt(@RequestBody UserSignInRequest request) {
    AccountResult signin = accountService.signin(request.toCommand());
    String token = authorization.login(
        new AuthorizationCommand(signin.getId(), signin.getEmail(),
            signin.getRole())
    );
    signin.addToken(token);
    return ApiResponse.success(signin);
  }

  /*
  * HttpServletRequest : 클라이언트의 서비스 요청 단위로 유지
  * */
  @PostMapping("/logout")
  public void logout(HttpServletRequest request) {
    authorization.logout(request);
  }
}
