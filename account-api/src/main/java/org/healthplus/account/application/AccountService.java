package org.healthplus.account.application;

import lombok.extern.slf4j.Slf4j;
import org.healthplus.account.application.command.SigninCommand;
import org.healthplus.account.application.command.SignupCommand;
import org.healthplus.account.application.result.AccountResult;
import org.healthplus.account.domain.User;
import org.healthplus.account.domain.exception.EmailInfoMisMatchException;
import org.healthplus.account.domain.exception.PasswordMisMatchException;
import org.healthplus.account.domain.EncryptMapper;
import org.healthplus.account.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class AccountService {

  private final UserRepository userRepository;
  private final EncryptMapper encryptMapper;

  @Autowired
  public AccountService(UserRepository userRepository, EncryptMapper encryptMapper) {
    this.userRepository = userRepository;
    this.encryptMapper = encryptMapper;
  }

  @Transactional
  public AccountResult signup(SignupCommand signupCommand) {
    log.info("AccountService works well");
    User signupUser = new User(
        signupCommand.getName(),
        encryptMapper.encoder(signupCommand.getPassword()),
        signupCommand.getEmail(),
        signupCommand.getPhoneNumber(),
        signupCommand.getRole()
    );
    User user = userRepository.save(signupUser);
    return AccountResult.fromUser(user);
  }

  @Transactional
  public AccountResult signin(SigninCommand signinCommand) {
    User findUser = userRepository.findByEmail(signinCommand.getEmail());
    if (findUser == null) {
      // domain에 관련된 예외입니다. 따라서 domain layer에 존재하는 것이 맞습니다.
      throw new EmailInfoMisMatchException("이메일이 일치하지 않습니다.");
    }
    if (!encryptMapper.isMatch(signinCommand.getPassword(), findUser.getPassword())) {
      throw new PasswordMisMatchException("패스워드가 일치하지 않습니다.");
    }
    return AccountResult.fromUser(findUser);
  }
}
