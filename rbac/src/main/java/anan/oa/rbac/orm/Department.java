package anan.oa.rbac.orm;

import anan.oa.rbac.RbacTable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * @author anan
 * @created 2019/2/3 15:31
 */
@Entity(name= RbacTable.department)
@Data
@DynamicUpdate
public class Department implements Serializable {

  private static final long serialVersionUID = -5204972810735115926L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer id;

  @JoinColumn(name="parent_id")
  @ManyToOne(cascade = CascadeType.REFRESH, optional = true, fetch = FetchType.EAGER)
  private Department parent;

  @Column(name = "name")
  @NotNull(message = "Department name cannot be null")
  @JsonIgnore
  private String name;

  @JoinColumn(name = "approval_user_id")
  @NotNull(message = "approval User cannot be null")
  @ManyToOne(cascade = CascadeType.REFRESH, optional = true, fetch = FetchType.EAGER)
  private User approvalUserId;

  @Column(name = "create_time")
  private Timestamp createTime;

  @ManyToMany(fetch = FetchType.EAGER, targetEntity = User.class)
  @JoinTable(name = RbacTable.userAndDepartment, joinColumns = @JoinColumn(name = "department_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
  @SortNatural
  private Set<User> user;



}
