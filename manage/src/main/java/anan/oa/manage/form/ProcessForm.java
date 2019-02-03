package anan.oa.manage.form;

import anan.oa.rbac.orm.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author anan
 * @created by anan on 2019/1/25 18:32
 */
@Data
@Setter
@Getter
public class ProcessForm {

  private Integer id;

  @NotNull(message = "流程名称必填")
  private String name;

  @NotNull(message = "流程类型必填")
  private Integer typeId;

  @NotNull(message = "流程进度必填")
  private Integer scheduleId;

  @NotNull(message = "流程时间段必填")
  private Integer processTime;

  private User createUserId;

  private User updateUserId;

  private User approvalUserId;

  private String remark;




}
