package anan.oa.manage.service.impl;

import anan.base.core.orm.ResponseResult;
import anan.base.core.service.BaseService;
import anan.oa.manage.orm.ProcessLog;
import anan.oa.manage.repository.ProcessLogRepository;
import anan.oa.manage.service.ProcessLogService;
import anan.oa.rbac.service.DictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author anan
 * @created 2019/1/22 11:52
 */

@Transactional
@Service
@Slf4j
public class ProcessLogServiceImpl implements ProcessLogService {

  @Autowired
  private ProcessLogRepository processLogRepository;
  @Autowired
  private DictionaryService dictionaryService;

  @Autowired
  private BaseService baseService;

  @Override
  public Page<ProcessLog> findAll(Pageable pageable) {
    return processLogRepository.findAll(pageable);
  }


  @Override
  public List<ProcessLog> findAll() {
    return processLogRepository.findAll();
  }

  @Override
  public ProcessLog findOne(Integer id) {
    return processLogRepository.findById(id).get();
  }

  @Override
  public ProcessLog save(ProcessLog data) {
    data.setId(null);
    return update(data);
  }

  @Override
  public ProcessLog update(ProcessLog data) {
    return processLogRepository.save(data);
  }

  @Override
  public ResponseResult delete(String id, ResponseResult result) {
    return baseService.delete(id, processLogRepository, result);
  }
}
