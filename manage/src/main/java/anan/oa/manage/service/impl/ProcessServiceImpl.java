package anan.oa.manage.service.impl;

import anan.base.core.enums.ResultEnum;
import anan.base.core.exception.CoreException;
import anan.base.core.orm.ResponseResult;
import anan.base.core.service.BaseService;
import anan.oa.manage.orm.Process;
import anan.oa.manage.repository.ProcessRepository;
import anan.oa.manage.service.ProcessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author anan
 * @created 2019/1/22 11:52
 */

@Transactional
@Service
public class ProcessServiceImpl implements ProcessService {

  @Autowired
  private ProcessRepository processRepository;
  @Autowired
  private BaseService baseService;

  @Override
  public List<Process> findAll() {
    return processRepository.findAll();
  }

  @Override
  public Process findOne(Integer id) {
    return processRepository.findById(id).get();
  }

  @Override
  public Process save(Process data) {
    data.setId(null);
    return processRepository.save(data);
  }

  @Override
  public Process update(Process data) {
    return processRepository.save(data);
  }

  @Override
  public ResponseResult delete(String id, ResponseResult result) {
    return baseService.delete(id, processRepository, result);
  }
}
