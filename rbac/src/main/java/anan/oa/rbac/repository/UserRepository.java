package anan.oa.rbac.repository;

import anan.oa.rbac.RbacTable;
import anan.oa.rbac.orm.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


/**
 * @author anan
 * Created by anan on 2018/8/27.
 */
public interface UserRepository  extends JpaRepository<User, Integer>{//, JpaSpecificationExecutor<Role> {

  User findByAccount(String account);

  @Modifying
  @Query(value = "update " + RbacTable.user + " set department_id = ?1  where id = ?2", nativeQuery = true)
  Integer updateDepartmentIdById(Integer department_id, Integer user_id);
}
