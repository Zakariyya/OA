package anan.oa.web.controller.rabc;

import anan.base.core.enums.ResultEnum;
import anan.base.core.orm.ResponseResult;
import anan.base.core.util.ResultVOUtil;
import anan.base.core.vo.ResultVO;
import anan.oa.rbac.form.MenuForm;
import anan.oa.rbac.orm.Menu;
import anan.oa.rbac.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author anan
 * @created 2019/2/24 15:20
 */
@RestController
@RequestMapping("/menu")
@Slf4j
public class MenuController {

  @Autowired
  private MenuService menuService;

  /**
   * findAll
   * @return ResultVO<User2UserDto>
   */
  @GetMapping("")
  public ResultVO findAll(){
    List<Menu> all = menuService.findAll();
    return ResultVOUtil.success(all);
  }

  /**
   * findOne
   * @param id primary key
   * @return ResultVO
   */
  @GetMapping("/{id}")
  public ResultVO findOne(@PathVariable("id") Integer id){
    return ResultVOUtil.success(menuService.findOne(id));
  }


  /**
   * add
   * @param data :UserDto pojo
   * @return ResultVO
   */
  @ResponseBody
  @PostMapping("")
  public ResultVO add(@Valid @RequestBody MenuForm data, BindingResult bindingResult){
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
  public ResultVO save(@PathVariable("id") Integer id, @Valid @RequestBody MenuForm data, BindingResult bindingResult){
    data.setId(id);
    if (bindingResult.hasErrors()) {
      log.error("[rbac模块-菜单]参数不正确, Menu={}", data);
      return ResultVOUtil.error(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
    }
    Menu update = menuService.update(data,new ResponseResult());
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
    return ResultVOUtil.result(menuService.delete(id, new ResponseResult()));
  }


}
