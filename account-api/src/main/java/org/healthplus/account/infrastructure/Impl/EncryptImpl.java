package org.healthplus.account.infrastructure.Impl;

import org.healthplus.account.domain.EncryptMapper;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class EncryptImpl implements EncryptMapper {

  @Override
  public String encoder(String plainText) {
    return BCrypt.hashpw(plainText, BCrypt.gensalt());
  }

  @Override
  public boolean isMatch(String Password, String hashed) {
    return BCrypt.checkpw(Password, hashed);
  }

}
