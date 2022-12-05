package org.healthplus.account.infrastructure;

import org.healthplus.account.domain.EncryptMapper;
import org.mindrot.jbcrypt.BCrypt;

public class EncryptMapperStub implements EncryptMapper {

  @Override
  public String encoder(String plainText) {
    return BCrypt.hashpw(plainText, BCrypt.gensalt());
  }

  @Override
  public boolean isMatch(String password, String hashed) {
    return BCrypt.checkpw(password, hashed);
  }
}
