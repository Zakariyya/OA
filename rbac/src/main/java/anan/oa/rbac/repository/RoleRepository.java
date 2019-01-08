package anan.oa.rbac.repository;

import anan.oa.rbac.orm.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author anan
 * Created by anan on 2018/8/27.
 */
public interface RoleRepository  extends JpaRepository<Role, Integer> {

}
