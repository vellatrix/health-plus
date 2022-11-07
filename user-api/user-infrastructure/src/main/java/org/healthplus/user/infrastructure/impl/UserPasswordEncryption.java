package org.healthplus.user.infrastructure.impl;

import org.healthplus.user.domain.PasswordEncryption;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserPasswordEncryption implements PasswordEncryption {

  // TODO: 2022/10/30 configuration package 만들기
  private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(31);

  @Override
  public String encryptor(String password) {
    return passwordEncoder.encode(password);
  }

  @Override
  public boolean matchPassword(String encryptedPassword, String plainText) {
    if (encryptedPassword.equals(passwordEncoder.encode(plainText))) {
      return true;
    }
    return false;
  }
}
