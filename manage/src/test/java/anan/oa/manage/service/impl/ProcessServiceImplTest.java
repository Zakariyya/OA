package anan.oa.manage.service.impl;

import anan.base.core.orm.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import anan.oa.manage.orm.Process;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProcessServiceImplTest {

  @Autowired
  private ProcessServiceImpl processService;

  public Process make(){
    Process data = new Process();
    data.setId(1);
    data.setName("process name");
    return data;
  }

  @Test
  public void findAll() {

    log.info("processService.findAll();==>"+processService.findAll());
  }

  @Test
  public void findOne() {
    log.info("processService.findOne();==>"+processService.findOne(1));
  }

  @Test
  public void save() {
//    log.info("processService.save();==>"+processService.save(make()));

  }

  @Test
  public void update() {
//    log.info("processService.save();==>"+processService.update(make()));

  }

  @Test
  public void delete() {
    ResponseResult result = new ResponseResult();
//    log.info("processService.save();==>"+processService.delete("1",result));

  }
}