package anan.oa.rbac.service;

import anan.base.core.orm.ResponseResult;
import anan.oa.rbac.orm.Dictionary;

import java.util.List;

/**
 * @author anan
 * Created by anan on 2019/01/23.
 */
public interface DictionaryService {

  List<Dictionary> findAll();

  Dictionary findOne(Integer id);

  Dictionary save(Dictionary data);

  Dictionary update(Dictionary data);

  ResponseResult delete(String id, ResponseResult result);


}
