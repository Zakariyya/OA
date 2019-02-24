package anan.oa.rbac.form;

import anan.base.core.form.CoreForm;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author anan
 * @created 2019/2/3 15:57
 */
@Data
public class MenuForm extends CoreForm<Integer> {

  private Integer id;

  private Integer parentId;

  private String name;

  private String url;

  private String icon;

  private String sort;

  private String menuTypeId;

  private Integer enabled;

  private String remark;

}
