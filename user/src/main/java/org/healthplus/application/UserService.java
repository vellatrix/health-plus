package org.healthplus.application;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.healthplus.domain.PasswordEncryption;
import org.healthplus.domain.UserRepository;
import org.healthplus.domain.entity.User;
import org.healthplus.domain.exception.PasswordMismatchException;
import org.healthplus.domain.exception.UserExistException;
import org.healthplus.domain.exception.UserNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncryption passwordManager;

  @Transactional
  public void signUp(String id, String name, String email, String password, String phoneNumber) {

    if (userRepository.existUser(id)) {
      throw new UserExistException();
    }

    // TODO: 2022/10/30 email 관련된 도메인 정책 생각해보기
    String encryptedPW = passwordManager.encryptor(password);
    User user = new User(id, name, email, encryptedPW, phoneNumber, LocalDateTime.now());
    userRepository.save(user);
  }

  public void login(String id, String password) {
    User user = userRepository.findUserById(id);
    if (user == null) {
      throw new UserNotFoundException();
    }

    boolean matchResult = passwordManager.matchPassword(user.getId(), password);
    if (!matchResult) {
      throw new PasswordMismatchException();
    }

    // TODO: 2022/10/30 인증 인가 
  }
}
