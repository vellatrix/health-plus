package org.healthplus.user.application;

import lombok.RequiredArgsConstructor;
import org.healthplus.user.domain.PasswordEncryption;
import org.healthplus.user.domain.TokenGenerator;
import org.healthplus.user.domain.UserRepository;
import org.healthplus.user.domain.entity.User;
import org.healthplus.user.domain.exception.PasswordMismatchException;
import org.healthplus.user.domain.exception.UserNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final TokenGenerator tokenGenerator;
  private final UserRepository userRepository;
  private final PasswordEncryption passwordManager;

  @Transactional
  public void signUp(String id, String nickName, String email, String password, String phoneNumber) {
  }

  public void login(String email, String password) {
    User user = userRepository.findByEmail(email);
    if (user == null) {
      throw new UserNotFoundException();
    }

    boolean matchResult = passwordManager.matchPassword(user.getPassword(), password);
    if (!matchResult) {
      throw new PasswordMismatchException();
    }

    // TODO: 2022/10/30 인증 인가
    /*String token = tokenGenerator.generate(
        new TokenPayloadDto(user.getId(), user.getName(), user.getEmail()));*/
  }
}
