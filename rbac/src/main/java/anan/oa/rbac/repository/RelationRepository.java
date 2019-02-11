package anan.oa.rbac.repository;

import anan.oa.rbac.RbacTable;
import anan.oa.rbac.orm.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import static anan.oa.rbac.RbacTable.department;

/**
 * @author anan
 * @created 2019/2/8 16:55
 */

public interface RelationRepository {//extends JpaRepository<T, Integer> { {

//  String TABLE = RbacTable.userAndDepartment;
//
//  @Modifying
//  @Query(value = "INSERT INTO " + TABLE + " VALUES(?1, ?2)", nativeQuery = true)
//  void saveUserDepartmentRelation(Integer user, Integer department);



}
