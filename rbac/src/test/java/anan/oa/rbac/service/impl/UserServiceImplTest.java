package anan.oa.rbac.service.impl;


import anan.oa.rbac.orm.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author anan
 * @created by anan on 2019/1/24 11:57
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class UserServiceImplTest {

  @Autowired
  private UserServiceImpl userService;

  public User make(){
    User data = new User();
    data.setAccount("anan");
    data.setEmail("2500@qq.com");
    data.setName("anan-name");
    data.setPassword("123456");
    data.setPhone("13414066655");

    return data;
  }

  @Test
  public void findAll() {
  }

  @Test
  public void findOne() {
  }

  @Test
  public void save() {
    log.info("userService.save()-->"+userService.save(make()));
  }

  @Test
  public void update() {
  }

  @Test
  public void delete() {
  }
}