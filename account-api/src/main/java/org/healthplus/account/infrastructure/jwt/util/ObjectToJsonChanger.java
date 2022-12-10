package org.healthplus.account.infrastructure.jwt.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectToJsonChanger {

  private final static ObjectMapper obm = new ObjectMapper();

  public static String changer(Object obj){
    String jsonString;
    try {
      jsonString = obm.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
    return jsonString;
  }

}
