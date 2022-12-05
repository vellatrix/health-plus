package org.healthplus.account.domain;

public interface EncryptMapper {

  String encoder(String plainText);

  boolean isMatch(String password, String hashed);

}
