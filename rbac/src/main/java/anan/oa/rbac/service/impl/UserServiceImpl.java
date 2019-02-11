package anan.oa.rbac.service.impl;

import anan.base.core.orm.ResponseResult;
import anan.base.core.service.BaseService;
import anan.oa.rbac.orm.User;
import anan.oa.rbac.repository.UserRepository;
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
@Slf4j
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BaseService baseService;

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public User findOne(Integer id) {
    return userRepository.findById(id).get();
  }

  @Transactional
  @Override
  public User save(User data) {
    data.setId(null);
    return this.update(data);
  }

  @Transactional
  @Override
  public User update(User data) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    data.setPassword(encoder.encode(data.getPassword()));
    return userRepository.save(data);
  }

  @Override
  public Integer updateDepartmentIdById(User user) {
    return userRepository.updateDepartmentIdById(user.getDepartmentId(), user.getId());
  }

  @Override
  public ResponseResult delete(String id, ResponseResult result) {
    return baseService.delete(id, userRepository, result);
  }

}
