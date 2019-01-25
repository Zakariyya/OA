package anan.oa.manage.dto;

import anan.oa.rbac.orm.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author anan
 * Created on 2018/8/22.
 */
@Data
public class ProcessDto {

  private Integer id;

  //  @NotBlank(message = "内容必填")
  private String name;

  private String type;

  private String schedule;

  private String processTime;

  private User createUserId;

  private User updateUserId;

  private User approvalUserId;

  private Long createTime;

  private Long updateTime;

  private String remark;

}
