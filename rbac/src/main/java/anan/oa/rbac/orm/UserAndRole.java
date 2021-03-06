package anan.oa.rbac.orm;

import anan.oa.rbac.RbacTable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * @author anan
 * Created on 2018/8/27.
 *
 * watch Dictionary class
 *
 */
@Entity(name= RbacTable.userAndRole)
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserAndRole {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer id;

  @JoinColumn(name="user_id")
  @ManyToOne(cascade = CascadeType.REFRESH, optional = true, fetch = FetchType.EAGER)
  private User user;

  @JoinColumn(name="role_id")
  @ManyToOne(cascade = CascadeType.REFRESH, optional = true, fetch = FetchType.EAGER)
  private Dictionary role;

}
