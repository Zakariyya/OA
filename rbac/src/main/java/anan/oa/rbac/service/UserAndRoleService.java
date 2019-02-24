package anan.oa.rbac.service;
import anan.base.core.orm.ResponseResult;
import anan.oa.rbac.orm.MenuAndRole;
import anan.oa.rbac.orm.UserAndRole;

import java.util.List;

/**
 * @author anan
 * Created by anan on 2018/8/27.
 */
public interface UserAndRoleService {

  List<UserAndRole> findAll();

  UserAndRole findOne(Integer id);

  UserAndRole save(UserAndRole data);

  UserAndRole update(UserAndRole data) ;

  ResponseResult delete(String id, ResponseResult result);





}
