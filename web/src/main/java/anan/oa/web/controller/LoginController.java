package anan.oa.web.controller;

import anan.oa.web.config.WebSecurityConfig;
import anan.oa.rbac.orm.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author anan
 * @created by anan on 2018/12/28 16:59
 */
@RestController
public class LoginController {


  @Autowired
  WebSecurityConfig webSecurityConfig;

//
//  @RequestMapping(value = "/login", method = RequestMethod.GET)
//  public String login() {
//    System.out.println("/login");
//    return "login";
//  }

//  @RequestMapping("/")
//  public String root() {
//    return "index";
//  }
//
//
//  @RequestMapping("/logout")
//  public String logout() {
//    webSecurityConfig.logoutSuccessHandler();
//    return "logout";
//  }
//
//
//  @RequestMapping(value = "/error", method = RequestMethod.GET)
//  public String error() {
//    System.out.println("/error");
//    return "error";
//  }

  public User getUser() { //为了session从获取用户信息,可以配置如下
    User user = new User();
    SecurityContext ctx = SecurityContextHolder.getContext();
    Authentication auth = ctx.getAuthentication();
    if (auth.getPrincipal() instanceof UserDetails) user = (User) auth.getPrincipal();
    return user;
  }

  public HttpServletRequest getRequest() {
    return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
  }
}
