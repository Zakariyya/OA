package anan.oa.rbac.service.impl;

import anan.base.core.orm.ResponseResult;
import anan.oa.rbac.orm.Dictionary;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DictionaryServiceImplTest {

  @Autowired
  private DictionaryServiceImpl dictionaryService;

  public Dictionary make(){
    Dictionary data = new Dictionary();
//    data.setId();
    data.setDictType("processType");
    data.setOptionValue("personal leave");
    data.setLabel("事假");
    data.setRemark("流程类型");
    data.setShowOrder(1);
    data.setEditable(1);
    return data;
  }

  @Test
  public void findAll() {
    log.info("dictionaryService.findAll()-->"+dictionaryService.findAll());
  }

  @Test
  public void findOne() {
    log.info("dictionaryService.findAll()-->"+dictionaryService.findAll());

  }

  @Test
  public void save() {
    Dictionary make = make();
    log.info("dictionaryService.findAll()-->"+dictionaryService.save(make));

  }

  @Test
  public void update() {
    Dictionary make = make();
    log.info("dictionaryService.findAll()-->"+dictionaryService.update(make));

  }

  @Test
  public void delete() {
    ResponseResult result = new ResponseResult();
    log.info("dictionaryService.findAll()-->"+dictionaryService.delete("1",result));

  }
}