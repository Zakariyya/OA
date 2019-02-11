package anan.oa.rbac.form;

import anan.oa.rbac.orm.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author anan
 * @created 2019/2/3 15:57
 */
@Data
@Setter
@Getter
public class DepartmentForm {

  private Integer id;

  private Integer parentId;


  private String name;

  private Integer approvalUserId;

  /**
   * 用逗号分隔
   * 1,24,5,6,7,2
   */
  @NotNull(message = "用户不能为空")
  private String users;

}
