package anan.oa.manage.orm;

import anan.oa.manage.ManageTable;
import anan.oa.rbac.orm.Dictionary;
import anan.oa.rbac.orm.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author anan
 * @created 2019/1/21 8:43
 */

@Entity(name= ManageTable.process)
@Data
@ToString
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
  @JoinColumn(name = "type_id")
  @ManyToOne(cascade = CascadeType.REFRESH, optional = true, fetch = FetchType.EAGER)
  private Dictionary typeId;

  /**
   * process schedule ( by dict_id)
   */
  @JoinColumn(name = "schedule_id")
  @ManyToOne(cascade = CascadeType.REFRESH, optional = true, fetch = FetchType.EAGER)
  private Dictionary scheduleId;

  /**
   * process schedule ( by dict_id)
   */
  @JoinColumn(name = "process_time")
  @ManyToOne(cascade = CascadeType.REFRESH, optional = true, fetch = FetchType.EAGER)
  private Dictionary processTime;

  @JoinColumn(name = "create_user_id")
  @ManyToOne(cascade = CascadeType.REFRESH, optional = true, fetch = FetchType.EAGER)
  private User createUserId;

  @JoinColumn(name = "update_user_id")
  @ManyToOne(cascade = CascadeType.REFRESH, optional = true, fetch = FetchType.EAGER)
  private User updateUserId;

  @JoinColumn(name = "approval_user_id")
  @ManyToOne(cascade = CascadeType.REFRESH, optional = true, fetch = FetchType.EAGER)
  private User approvalUserId;

  @Column(name = "create_time")
  private Timestamp createTime;

  @Column(name = "update_time")
  private Timestamp updateTime;

  @Column(name = "remark")
  private String remark;

//  public Long getCreateTime() {
//    return this.createTime.getTime();
//  }
//
//  public Long getUpdateTime() {
//    return this.updateTime.getTime();
//  }

}
