package anan.oa.manage.dto;

import lombok.Data;

import java.sql.Timestamp;

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

  private String createUserName;

  private String updateUserName;

  private String approvalUserName;

  private Timestamp createTime;

  private Timestamp updateTime;

  private String remark;

}
