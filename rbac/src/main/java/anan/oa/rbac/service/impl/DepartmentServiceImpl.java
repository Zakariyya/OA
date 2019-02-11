package anan.oa.rbac.service.impl;

import anan.base.core.exception.CoreException;
import anan.base.core.orm.ResponseResult;
import anan.base.core.service.BaseService;
import anan.oa.rbac.enums.UserEnum;
import anan.oa.rbac.form.DepartmentForm;
import anan.oa.rbac.orm.Department;
import anan.oa.rbac.orm.User;
import anan.oa.rbac.repository.DepartmentRepository;
import anan.oa.rbac.repository.RelationRepository;
import anan.oa.rbac.service.DepartmentService;
import anan.oa.rbac.service.UserService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author anan
 * @created 2019/2/3 15:47
 */
@Transactional
@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

  @Autowired
  private DepartmentRepository repository;

  @Autowired
  private UserService userService;

  @Autowired
  private RelationRepository relationRepository;

  @Autowired
  private BaseService baseService;

  @Override
  public Page<Department> findAll(Pageable pageable) {
    return repository.findAll(pageable);
  }

  @Override
  public List<Department> findAll() {
    return repository.findAll();
  }

  @Override
  public Department findOne(Integer id) {
    return repository.findById(id).get();
  }

  @Override
  public Department save(Department data) {
    data.setId(null);
    return repository.save(data);
  }

  @Override
  public Department update(DepartmentForm form) {
    Department data = new Department();
    BeanUtils.copyProperties(form,data);

    data.setParent(this.findOne(form.getParentId()));
    data.setApprovalUserId(userService.findOne(form.getApprovalUserId()));
    val department = repository.save(data);

    String[] users = form.getUsers().split(",");

    for (String item : users) {
      User user = userService.findOne(Integer.parseInt(item));
      if (null == user) {
        throw new CoreException(UserEnum.NOT_FOUND.getCode(),UserEnum.NOT_FOUND.getMessage());
      }
      user.setDepartmentId(department.getId());
      if(1 != userService.updateDepartmentIdById(user)){
        throw new CoreException(UserEnum.NOT_FOUND.getCode(),UserEnum.NOT_FOUND.getMessage());
      }
    }
    return department;
  }

  @Override
  public ResponseResult delete(String id, ResponseResult result) {
    return baseService.delete(id, repository, result);
  }
}
