package anan.oa.manage.service;

import anan.base.core.orm.ResponseResult;
import anan.oa.manage.form.ProcessForm;
import anan.oa.manage.orm.Process;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProcessService {

  Page<Process> findAll(Pageable pageable);

  List<Process> findAll();

  Process findOne(Integer id);

  Process save(ProcessForm form);

  Process update(ProcessForm form);

  ResponseResult delete(String id, ResponseResult result);


}
