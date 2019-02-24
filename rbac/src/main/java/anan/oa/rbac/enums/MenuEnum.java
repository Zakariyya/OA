package anan.oa.rbac.enums;

import lombok.Getter;

/**
 * @author anan
 * @createDate 2019-02-23
 */
@Getter
public enum MenuEnum {

  /**
   * Menu Type
   */

  MODUEL(0, "MODULE"),
  PAGE(1,"PAGE"),
  BUTTON(2, "BUTTON"),

  ;

  private Integer code;
  private String message;

  MenuEnum(Integer code, String message) {
    this.code = code;
    this.message = message;
  }
}

