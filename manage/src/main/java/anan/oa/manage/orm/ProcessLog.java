package anan.oa.manage.orm;

import anan.oa.manage.ManageTable;
import anan.oa.rbac.orm.Dictionary;
import anan.oa.rbac.orm.User;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author anan
 * @created 2019/1/21 22:06
 */
@Entity(name= ManageTable.processLog)
@Data
@DynamicUpdate
public class ProcessLog implements Serializable {

  private static final long serialVersionUID = 1144830155395248411L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer id;


  @JoinColumn(name="process_id")
  @ManyToOne(cascade = CascadeType.REFRESH, optional = true, fetch = FetchType.EAGER)
  private Process processId;

  @JoinColumn(name="schedule_id")
  @ManyToOne(cascade = CascadeType.REFRESH, optional = true, fetch = FetchType.EAGER)
  private Dictionary scheduleId;

  @JoinColumn(name="update_user_id")
  private User updateUserId;

  @Column(name = "create_time")
  private String createTime;

  @Column(name = "remark")
  private String remark;
}
