package org.healthplus.user.infrastructure.jpa;

import lombok.RequiredArgsConstructor;
import org.healthplus.user.domain.UserRepository;
import org.healthplus.user.domain.entity.User;
import org.healthplus.user.infrastructure.exception.ErrorCode;
import org.healthplus.user.infrastructure.exception.UserException;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {

  private final JpaUserRepository jpaUserRepository;


  @Override
  public User save(User user) {
    return jpaUserRepository.save(user);
  }

  @Override
  public User findByEmail(String email) {
    return jpaUserRepository.findByEmail(email)
        .orElseThrow(() -> new UserException(ErrorCode.USER_NOT_FOUND));
  }

  @Override
  public boolean existsByEmail(String email) {
    return jpaUserRepository.existsByEmail(email);
  }

  @Override
  public boolean isMatchPassword(String password) {
    return false;
  }


}
