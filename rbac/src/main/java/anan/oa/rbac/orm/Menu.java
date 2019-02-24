package anan.oa.rbac.orm;

import anan.oa.rbac.RbacTable;
import anan.oa.rbac.enums.MenuEnum;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author anan
 * @created 2019/2/23 14:59
 */

@Entity(name= RbacTable.menu)
@Data
@DynamicUpdate
public class Menu implements Serializable,Comparable<Menu>{

  private static final long serialVersionUID = 984884329032822633L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer id;


  @JoinColumn(name="parent_id")
  @ManyToOne(cascade = CascadeType.REFRESH, optional = true, fetch = FetchType.EAGER)
  private Menu parent;

  @Column(name = "name")
  private String name;

  @Column(name = "url")
  private String url;

  @Column(name = "icon")
  private String icon;

  @Column(name = "sort")
  private String sort;

  @JoinColumn(name="menu_type_id")
  private String menuTypeId;

  @Column(name = "enabled")
  private Dictionary enabled;

  @Column(name = "create_time")
  private Timestamp createTime;

  @Column(name = "update_time")
  private Timestamp updateTime;

  @Column(name = "remark")
  private String remark;

  @Override
  public int compareTo(Menu o) {
    return  Integer.compare(this.id, o.id);
  }
}
