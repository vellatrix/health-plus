package org.healthplus.account.domain;

import org.healthplus.account.domain.User;

public interface UserRepository {

  User save(User user);

  User findByEmail(String userEmail);

  // User findById(Long id);
}
