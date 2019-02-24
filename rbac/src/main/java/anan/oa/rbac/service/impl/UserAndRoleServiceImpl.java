package anan.oa.rbac.service.impl;

import anan.base.core.orm.ResponseResult;
import anan.base.core.service.BaseService;
import anan.oa.rbac.orm.User;
import anan.oa.rbac.orm.UserAndRole;
import anan.oa.rbac.repository.UserAndRoleRepository;
import anan.oa.rbac.repository.UserRepository;
import anan.oa.rbac.service.UserAndRoleService;
import anan.oa.rbac.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author anan
 * Created on 2018/8/27.
 */

@Service
@Transactional
@Slf4j
public class UserAndRoleServiceImpl implements UserAndRoleService {

  @Autowired
  private UserAndRoleRepository repository;

  @Autowired
  private BaseService baseService;

  @Override
  public List<UserAndRole> findAll() {
    return repository.findAll();
  }

  @Override
  public UserAndRole findOne(Integer id) {
    return repository.findById(id).get();
  }

  @Override
  public UserAndRole save(UserAndRole data) {
    data.setId(null);
    return this.update(data);
  }

  @Override
  public UserAndRole update(UserAndRole data) {

    return repository.save(data);
  }


  @Override
  public ResponseResult delete(String id, ResponseResult result) {
    return baseService.delete(id, repository, result);
  }

}
