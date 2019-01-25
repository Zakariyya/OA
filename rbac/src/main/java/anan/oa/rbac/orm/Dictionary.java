package anan.oa.rbac.orm;

import anan.oa.rbac.RbacTable;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
  @NotNull(message = "dictType is no null")
  @Column(name="dict_type")
  private String dictType;

  /**
   * 选项值
   */
  @NotNull(message = "optionValue is no null")
  @Column(name="option_value")
  private String optionValue;

  /**
   * 选项文本
   */
  @Column(name="label")
  @NotNull(message = "label is no null")
  private String label;

  /**
   * 扩展字段a
   */
  @Column(name="ex1")
  private String ex1;

  /**
   * 扩展字段b
   */
  @Column(name="ex2")
  private String ex2;

  /**
   * 选项备注
   */
  @Column(name="remark")
  private String remark;

  /**
   * 排序
   */
  @Column(name="show_order")
  private Integer  showOrder;

  /**
   * 是否可编辑(含删除)
   */
  @Column(name="editable")
  @NotNull(message = "editable is no null")
  private Integer  editable;


  @Override
  public int compareTo(Dictionary o) {
    return Integer.compare(this.id, o.id);
  }



}
