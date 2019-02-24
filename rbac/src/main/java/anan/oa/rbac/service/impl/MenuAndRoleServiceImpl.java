package anan.oa.rbac.service.impl;

import anan.base.core.orm.ResponseResult;
import anan.base.core.service.BaseService;
import anan.oa.rbac.orm.MenuAndRole;
import anan.oa.rbac.orm.UserAndRole;
import anan.oa.rbac.repository.MenuAndRoleRepository;
import anan.oa.rbac.repository.UserAndRoleRepository;
import anan.oa.rbac.service.MenuAndRoleService;
import anan.oa.rbac.service.UserAndRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MenuAndRoleServiceImpl implements MenuAndRoleService {

  @Autowired
  private MenuAndRoleRepository repository;

  @Autowired
  private BaseService baseService;

  @Override
  public List<MenuAndRole> findAll() {
    return repository.findAll();
  }

  @Override
  public MenuAndRole findOne(Integer id) {
    return repository.findById(id).get();
  }

  @Override
  public MenuAndRole save(MenuAndRole data) {
    data.setId(null);
    return this.update(data);
  }

  @Override
  public MenuAndRole update(MenuAndRole data) {
    return repository.save(data);
  }


  @Override
  public ResponseResult delete(String id, ResponseResult result) {
    return baseService.delete(id, repository, result);
  }

}
