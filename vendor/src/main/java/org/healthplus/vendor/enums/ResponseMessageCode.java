package org.healthplus.vendor.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseMessageCode {

  REGISTER_SUCCESS("등록 성공"),
  REGISTER_FAIL("등록 실패"),
  INQUIRY_SUCCESS("조회 성공"),
  INQUIRY_FAIL("조회 실패"),
  UPDATE_SUCCESS("변경 성공"),
  UPDATE_FAIL("변경 실패"),
  DELETE_SUCCESS("삭제 성공"),
  DELETE_FAIL("삭제 실패");

  private String content;
}
