package anan.oa.rbac.repository;

import anan.oa.rbac.orm.Department;
import anan.oa.rbac.orm.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @author anan
 * Created by anan on 2018/8/27.
 */
public interface DepartmentRepository extends JpaRepository<Department, Integer> , JpaSpecificationExecutor<User> {

}
