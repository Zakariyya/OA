package anan.oa.rbac.service.impl;

import anan.base.core.orm.ResponseResult;
import anan.base.core.service.BaseService;
import anan.base.core.util.VerifyForm;
import anan.oa.rbac.form.MenuForm;
import anan.oa.rbac.orm.Menu;
import anan.oa.rbac.repository.MenuRepository;
import anan.oa.rbac.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author anan
 * @created 2019/1/22 11:52
 */

@Transactional
@Service
@Slf4j
public class MenuServiceImpl implements MenuService {

  @Autowired
  private MenuRepository repository;
  @Autowired
  private BaseService baseService;
  @Autowired
  VerifyForm verifyForm;

  @Override
  public Page<Menu> findAll(Pageable pageable) {
    return repository.findAll(pageable);
  }


  @Override
  public List<Menu> findAll() {
    return repository.findAll();
  }

  @Override
  public Menu findOne(Integer id) {
    return repository.findById(id).get();
  }

  @Override
  public Menu save(MenuForm form) {
    form.setId(null);
    return update(form, new ResponseResult());
  }

  @Override
  public Menu update(MenuForm form, ResponseResult result) {
    Menu data = new Menu();
    if (null != form.getId()) {
      data = findOne(form.getId());
      verifyForm.dataIsNullOrFormParentIdEqId(data,form,result);
      if(result.hasErrors()){
        return null;
      }
    }
    if(null != form.getParentId()){
      data.setParent(findOne(form.getParentId()));
    }
    BeanUtils.copyProperties(form,data);
    return repository.save(data);
  }

  @Override
  public ResponseResult delete(String id, ResponseResult result) {
    return baseService.delete(id, repository, result);
  }
}
