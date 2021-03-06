package anan.oa.web.controller.rabc;

import anan.base.core.enums.ResultEnum;
import anan.base.core.exception.CoreException;
import anan.base.core.orm.ResponseResult;
import anan.base.core.util.ResultVOUtil;
import anan.base.core.vo.ResultVO;
import anan.oa.rbac.orm.User;
import anan.oa.rbac.service.UserService;
//import anan.oa.web.orm.User;
//import anan.oa.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author anan
 * Created on 2018/8/27.
 * Modify on 2018/12/26.
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

  @Autowired
  private UserService userService;

  /**
   * findAll
   * @return ResultVO<User2UserDto>
   */
  @GetMapping("")
  public ResultVO findAll(){
    List<User> all = userService.findAll();
    return ResultVOUtil.success(all);
  }

  /**
   * findOne
   * @param id primary key
   * @return ResultVO
   */
  @GetMapping("/{id}")
  public ResultVO findOne(@PathVariable("id") Integer id){
    return ResultVOUtil.success(userService.findOne(id));
  }


  /**
   * add
   * @param data :UserDto pojo
   * @return ResultVO
   */
  @ResponseBody
  @PostMapping("")
  public ResultVO add(@Valid @RequestBody User data, BindingResult bindingResult){
    data.setId(null);
    return save(null, data, bindingResult);
  }


  /**
   * update & save
   *
   * remark:
   *  throw new CoreException(ResultEnum.PARAM_ERROR.getCode(),
   *         bindingResult.getFieldError().getDefaultMessage());
   *
   * @param data :UserDto pojo
   * @return ResultVO
   */
  @ResponseBody
  @PutMapping("/{id}")
  public ResultVO save(@PathVariable("id") Integer id, @Valid @RequestBody User data, BindingResult bindingResult){
    data.setId(id);
    if (bindingResult.hasErrors()) {
      log.error("[rbac模块-用户]参数不正确, User={}", data);
      return ResultVOUtil.error(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
    }
    User update = userService.update(data);
    return ResultVOUtil.success(update);
  }

  /**
   * delete
   * @param id :User primary key
   * @return ResultVO
   *
   * remark: @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
   *
   */
  @DeleteMapping("/{id}")
  public ResultVO delete(@PathVariable("id") String id){
    return ResultVOUtil.result(userService.delete(id, new ResponseResult()));
  }



}
