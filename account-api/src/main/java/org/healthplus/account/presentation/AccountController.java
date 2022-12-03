package org.healthplus.account.presentation;

import java.util.List;
import org.healthplus.account.application.AccountService;
import org.healthplus.account.application.result.AccountResult;
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

  @Autowired
  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @PostMapping("/signup")
  public ApiResponse signUp(@RequestBody UserSignUpRequest request) {
    AccountResult signupResult = accountService.signup(request.toCommand());
    return ApiResponse.success(signupResult);
  }

  @PostMapping("/signin")
  public ApiResponse signin(@RequestBody UserSignInRequest request) {
    AccountResult signinResult = accountService.signin(request.toCommand());
    return ApiResponse.success(signinResult);
  }
}
