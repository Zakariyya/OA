package anan.oa.rbac.enums;

import anan.base.core.enums.ResultEnum;
import lombok.Getter;

@Getter
public enum UserEnum {

  /**
   * sex
   */
  MAN(0, "man"),
  WOMEN(1,"women"),

  NOT_FOUND(1100,"the user could not be found")

  ;

  private Integer code;
  private String message;

  UserEnum(Integer code, String message) {
    this.code = code;
    this.message = message;
  }
}

