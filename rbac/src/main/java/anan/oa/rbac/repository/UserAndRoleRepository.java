package anan.oa.rbac.repository;

import anan.oa.rbac.orm.UserAndRole;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author anan
 * Created by anan on 2018/8/27.
 */
public interface UserAndRoleRepository extends JpaRepository<UserAndRole, Integer>{//, JpaSpecificationExecutor<Role> {

}
