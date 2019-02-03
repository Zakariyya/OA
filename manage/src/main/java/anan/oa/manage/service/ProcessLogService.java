package anan.oa.manage.service;

import anan.base.core.orm.ResponseResult;
import anan.oa.manage.orm.ProcessLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProcessLogService {

  Page<ProcessLog> findAll(Pageable pageable);

  List<ProcessLog> findAll();

  ProcessLog findOne(Integer id);

  ProcessLog save(ProcessLog data);

  ProcessLog update(ProcessLog data);

  ResponseResult delete(String id, ResponseResult result);


}
