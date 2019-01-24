package anan.oa.rbac.service.impl;

import anan.base.core.orm.ResponseResult;
import anan.oa.rbac.orm.Dictionary;
import anan.oa.rbac.repository.DictionaryRepoitory;
import anan.oa.rbac.service.DictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author anan
 * @created 2019/1/23 15:08
 */

@Transactional
@Service
@Slf4j
public class DictionaryServiceImpl implements DictionaryService {

  @Autowired
  private DictionaryRepoitory dictionaryRepoitory;

  @Override
  public List<Dictionary> findAll() {
    return dictionaryRepoitory.findAll();
  }

  @Override
  public Dictionary findOne(Integer id) {
    return dictionaryRepoitory.findById(id).get();
  }

  @Override
  public Dictionary save(Dictionary data) {
    data.setId(null);
    return dictionaryRepoitory.save(data);
  }

  @Override
  public Dictionary update(Dictionary data) {
    return dictionaryRepoitory.save(data);
  }

  /**
   * todo
   * remark:
   * delete dictionary data need check every table data whether exist data about this dictionary
   *
   * @param id
   * @param result
   * @return
   */
  @Override
  public ResponseResult delete(String id, ResponseResult result) {
//    return dictionaryRepoitory.;

    return result;
  }

}
