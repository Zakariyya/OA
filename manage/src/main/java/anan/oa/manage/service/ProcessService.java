package anan.oa.manage.service;

import anan.base.core.orm.ResponseResult;
import anan.oa.manage.orm.Process;

import java.util.List;

public interface ProcessService {

  List<Process> findAll();

  Process findOne(Integer id);

  Process save(Process data);

  Process update(Process data);

  ResponseResult delete(String id, ResponseResult result);


}
