package anan.oa.manage.orm;

import anan.oa.manage.ManageTable;
import anan.oa.rbac.orm.Dictionary;
import anan.oa.rbac.orm.User;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author anan
 * @created 2019/1/21 8:43
 */

@Entity(name= ManageTable.process)
@Data
@DynamicUpdate
public class Process implements Serializable {

  private static final long serialVersionUID = 3420587958977956323L;
  /**
   * id
   */
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name")
  private String name;

  /**
   * process type（ by dict_id）
   */
  @Column(name = "type_id")
  @ManyToOne(cascade = CascadeType.REFRESH, optional = true, fetch = FetchType.EAGER)
  private Dictionary typeId;

  /**
   * process schedule ( by dict_id)
   */
  @Column(name = "schedule_id")
  @ManyToOne(cascade = CascadeType.REFRESH, optional = true, fetch = FetchType.EAGER)
  private Dictionary scheduleId;

  @Column(name = "create_user_id")
  @ManyToOne(cascade = CascadeType.REFRESH, optional = true, fetch = FetchType.EAGER)
  private User createUserId;

  @Column(name = "update_user_id")
  @ManyToOne(cascade = CascadeType.REFRESH, optional = true, fetch = FetchType.EAGER)
  private User updateUserId;

  @Column(name = "approval_user_id")
  @ManyToOne(cascade = CascadeType.REFRESH, optional = true, fetch = FetchType.EAGER)
  private User approvalUserId;

  @Column(name = "create_time")
  private Date createTime;

  @Column(name = "update_time")
  private Date updateTime;

  @Column(name = "remark")
  private String remark;



}
