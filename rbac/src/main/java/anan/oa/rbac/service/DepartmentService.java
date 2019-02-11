package anan.oa.rbac.service;

import anan.base.core.orm.ResponseResult;
import anan.oa.rbac.form.DepartmentForm;
import anan.oa.rbac.orm.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DepartmentService {

  Page<Department> findAll(Pageable pageable);

  List<Department> findAll();

  Department findOne(Integer id);

  Department save(Department data);

  Department update(DepartmentForm data);

  ResponseResult delete(String id, ResponseResult result);
}
