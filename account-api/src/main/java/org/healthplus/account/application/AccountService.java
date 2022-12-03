package org.healthplus.account.application;

import lombok.extern.slf4j.Slf4j;
import org.healthplus.account.application.command.SigninCommand;
import org.healthplus.account.application.command.SignupCommand;
import org.healthplus.account.application.result.AccountResult;
import org.healthplus.account.domain.entity.User;
import org.healthplus.account.domain.exception.EmailInfoMisMatchException;
import org.healthplus.account.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class AccountService {

  private final UserRepository userRepository;

  @Autowired
  public AccountService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public AccountResult signup(SignupCommand signupCommand) {
    log.info("AccountService works well");
    User signupUser = new User(
        signupCommand.getName(),
        signupCommand.getPassword(),
        signupCommand.getEmail(),
        signupCommand.getPhoneNumber(),
        signupCommand.getRole()
    );
    User user = userRepository.save(signupUser);
    return AccountResult.fromUser(user);
  }

  public AccountResult signin(SigninCommand signinCommand) {
    User findUser = userRepository.findByEmail(signinCommand.getEmail());
    if (findUser == null) {
      // domain에 관련된 예외입니다. 따라서 domain layer에 존재하는 것이 맞습니다.
      throw new EmailInfoMisMatchException("이메일이 일치하지 않습니다.");
    }
    return AccountResult.fromUser(findUser);
  }
}
