package anan.oa.rbac.orm;

import anan.oa.rbac.RbacTable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author anan
 * Created on 2018/8/27.
 */
@Entity(name= RbacTable.user)
@Data
@DynamicUpdate
public class User implements Serializable {

  private static final long serialVersionUID = 6650020328552169838L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "account")
  @NotNull(message = "account cannot be null")
  private String account;

  @Column(name = "password")
  @NotNull(message = "password cannot be null")
  @JsonIgnore
  private String password;

  @Column(name = "name")
  @NotNull(message = "name cannot be null")
  private String name;

  /**
   * in UserEnum
   * package com.anan.springboot.auth.enums;
   */
  @Column(name = "sex")
  private Integer sex;

  @Column(name = "email")
  private String email;

  @Column(name = "phone")
  private String phone;


//  @Column(name = "image")
//  private String image;       //用户头像

  /**
   * last login  ip
   */
  @Column(name = "last_ip")
  private String lastIp;

  /**
   * last login time
   */
  @Column(name = "last_time")
  private Date lastTime;



//  @ManyToMany(fetch = FetchType.EAGER, targetEntity = Role.class)
//  @JoinTable(name = RabcTable.userAndRole, joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//  @SortNatural
//  private Set<Role> roles;


}
