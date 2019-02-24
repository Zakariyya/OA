package anan.oa.rbac.orm;

import anan.oa.rbac.RbacTable;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @author anan
 * @created 2019/2/23 15:55
 */
@Entity(name= RbacTable.menu)
@Data
@DynamicUpdate
public class MenuAndRole {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer id;

  @JoinColumn(name="menu_id")
  @ManyToOne(cascade = CascadeType.REFRESH, optional = true, fetch = FetchType.EAGER)
  private Menu menu;

  @JoinColumn(name="role_id")
  @ManyToOne(cascade = CascadeType.REFRESH, optional = true, fetch = FetchType.EAGER)
  private Dictionary role;


}
