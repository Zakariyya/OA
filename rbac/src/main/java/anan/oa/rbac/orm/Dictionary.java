package anan.oa.rbac.orm;

import anan.oa.rbac.RbacTable;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author anan
 * @created 2019/1/22 11:33
 */
@Entity(name= RbacTable.dictionary)
@Data
@DynamicUpdate
public class Dictionary implements Serializable, Comparable<Dictionary>  {

  private static final long serialVersionUID = 3914492655482347220L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private  Integer  id;
  /**
   * 字典类型
   */
  @Column(name="dict_type")
  private String dictType;

  /**
   * 选项值
   */
  @Column(name="option_value")
  private String optionValue;

  /**
   * 选项文本
   */
  @Column(name="label")
  private String label;

  /**
   * 扩展字段a
   */
  @Column(name="k1")
  private String k1;

  /**
   * 扩展字段b
   */
  @Column(name="k2")
  private String k2;

  /**
   * 选项备注
   */
  @Column(name="option_remark")
  private String optionRemark;

  /**
   * 排序
   */
  @Column(name="show_order")
  private Integer  showOrder;

  /**
   * 是否可编辑(含删除)
   */
  @Column(name="editable")
  private Integer  editable;


  @Override
  public int compareTo(Dictionary o) {
    return Integer.compare(this.id, o.id);
  }



}
