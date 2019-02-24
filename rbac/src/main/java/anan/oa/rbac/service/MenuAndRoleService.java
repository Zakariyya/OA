package anan.oa.rbac.service;
import anan.base.core.orm.ResponseResult;
import anan.oa.rbac.orm.Menu;
import anan.oa.rbac.orm.MenuAndRole;

import java.util.List;

/**
 * @author anan
 * Created by anan on 2018/8/27.
 */
public interface MenuAndRoleService {

  List<MenuAndRole> findAll();

  MenuAndRole findOne(Integer id);

  MenuAndRole save(MenuAndRole data);

  MenuAndRole update(MenuAndRole data) ;

  ResponseResult delete(String id, ResponseResult result);





}
