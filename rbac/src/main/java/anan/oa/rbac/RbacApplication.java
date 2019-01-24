package anan.oa.rbac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"anan.base.core","anan.oa.rbac"})
public class RbacApplication {

  public static void main(String[] args) {
    SpringApplication.run(RbacApplication.class, args);
  }

}

