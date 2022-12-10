package org.healthplus.account.application;

import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.healthplus.account.application.command.SigninCommand;
import org.healthplus.account.application.command.SignupCommand;
import org.healthplus.account.application.result.AccountResult;
import org.healthplus.account.domain.User;
import org.healthplus.account.domain.exception.EmailInfoMisMatchException;
import org.healthplus.account.domain.exception.PasswordMisMatchException;
import org.healthplus.account.domain.EncryptMapper;
import org.healthplus.account.domain.UserRepository;
import org.healthplus.model.domain.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class AccountService {

  private final UserRepository userRepository;
  private final EncryptMapper encryptMapper;

  private final EventPublisher eventPublisher;

  public AccountService(UserRepository userRepository, EncryptMapper encryptMapper,
      EventPublisher eventPublisher) {
    this.userRepository = userRepository;
    this.encryptMapper = encryptMapper;
    this.eventPublisher = eventPublisher;
  }

  @Transactional
  public AccountResult signup(SignupCommand signupCommand) {
    User signupUser = User.register(
        signupCommand.getName(),
        encryptMapper.encoder(signupCommand.getPassword()),
        signupCommand.getEmail(),
        signupCommand.getPhoneNumber(),
        signupCommand.getRole()
    );
    User user = userRepository.save(signupUser);
    user.occurredEvents().forEach(eventPublisher::publish);
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

  @Transactional
  public void logout(HttpServletRequest request) {
    request.getSession().invalidate(); // 세션 종료
  }
  /*@Transactional
  public void changeEmail(Long userId, String email) {
    User user = userRepository.findById(userId);

    // user entity 안 changeEmail에서 event 생성
    user.changeEmail(email);

    // 생성된 이벤트를 가져와 발행
     user.occurredEvents().forEach(eventPublisher::publish);
  }*/
}
