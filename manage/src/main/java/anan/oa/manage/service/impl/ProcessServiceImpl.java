package anan.oa.manage.service.impl;

import anan.base.core.orm.ResponseResult;
import anan.base.core.service.BaseService;
import anan.oa.manage.form.ProcessForm;
import anan.oa.manage.orm.Process;
import anan.oa.manage.repository.ProcessRepository;
import anan.oa.manage.service.ProcessService;
import anan.oa.rbac.service.DictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
public class ProcessServiceImpl implements ProcessService {

  @Autowired
  private ProcessRepository processRepository;
  @Autowired
  private DictionaryService dictionaryService;

  @Autowired
  private BaseService baseService;

  @Override
  public Page<Process> findAll(Pageable pageable) {
    return processRepository.findAll(pageable);
  }


  @Override
  public List<Process> findAll() {
    return processRepository.findAll();
  }

  @Override
  public Process findOne(Integer id) {
    return processRepository.findById(id).get();
  }

  @Override
  public Process save(ProcessForm form) {
    form.setId(null);
    return update(form);
  }

  @Override
  public Process update(ProcessForm form) {
    Process data = new Process();
    BeanUtils.copyProperties(form,data);

    data.setTypeId(dictionaryService.findOne(form.getTypeId()));
    data.setScheduleId(dictionaryService.findOne(form.getScheduleId()));
    data.setProcessTime(dictionaryService.findOne(form.getProcessTime()));

    return processRepository.save(data);
  }

  @Override
  public ResponseResult delete(String id, ResponseResult result) {
    return baseService.delete(id, processRepository, result);
  }
}
