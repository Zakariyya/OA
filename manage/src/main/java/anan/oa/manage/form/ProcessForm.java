package anan.oa.manage.form;

import anan.base.core.form.CoreForm;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;

/**
 * @author anan
 * @created by anan on 2019/1/25 18:32
 */
@Data
public class ProcessForm {

  private Integer id;

  @NotNull(message = "流程名称必填")
  private String name;

  @NotNull(message = "流程名称必填")
  private Integer typeId;

  @NotNull(message = "流程名称必填")
  private Integer scheduleId;

  private Integer processTime;

  @NotNull(message = "操作人必传")
  private Integer updateUserId;

  private Integer approvalUserId;

  private String remark;




}
