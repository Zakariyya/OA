package anan.oa.rbac.service;
import anan.base.core.orm.ResponseResult;
import anan.oa.rbac.form.MenuForm;
import anan.oa.rbac.orm.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author anan
 * Created by anan on 2018/8/27.
 */
public interface MenuService {

  Page<Menu> findAll(Pageable pageable);

  List<Menu> findAll();

  Menu findOne(Integer id);

  Menu save(MenuForm data);

  Menu update(MenuForm data,ResponseResult result) ;

  ResponseResult delete(String id, ResponseResult result);





}
