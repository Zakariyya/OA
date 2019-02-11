package anan.oa.rbac.service;
import anan.base.core.orm.ResponseResult;
import anan.oa.rbac.orm.User;

import java.util.List;

/**
 * @author anan
 * Created by anan on 2018/8/27.
 */
public interface UserService {

  List<User> findAll();

  User findOne(Integer id);

  User save(User data);

  User update(User data) ;

  Integer updateDepartmentIdById(User user);

  ResponseResult delete(String id, ResponseResult result);





}
