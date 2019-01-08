package anan.oa.rbac.service;



import anan.oa.rbac.orm.UserAndRole;

import java.util.List;

/**
 * @author anan
 * @created by anan on 2018/12/27 14:54
 */
public interface UserAndRoleService {

  List<UserAndRole> findAll();

  UserAndRole findOne(Integer id);

  UserAndRole save(UserAndRole data);

  UserAndRole update(UserAndRole data);

  void delete(Integer id);

}
