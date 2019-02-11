package anan.oa.web.controller.rabc;

import anan.base.core.enums.ResultEnum;
import anan.base.core.orm.ResponseResult;
import anan.base.core.util.ResultVOUtil;
import anan.base.core.vo.ResultVO;
import anan.oa.rbac.form.DepartmentForm;
import anan.oa.rbac.orm.Department;
import anan.oa.rbac.orm.User;
import anan.oa.rbac.service.DepartmentService;
import anan.oa.web.security.AuthenticationFacade;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author anan
 * @created 2019/2/3 15:52
 */
@RestController
@RequestMapping("/depart")
@Slf4j
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;
  @Autowired
  private AuthenticationFacade authenticationFacade;

  /**
   * findAll by page
   * @return ResultVO<Category>
   */
  @GetMapping("/{page}/{size}")
  public ResultVO findAll(@PathVariable(value = "page") Integer page,
                          @PathVariable(value = "size") Integer size) throws InstantiationException, IllegalAccessException {
    PageRequest request = PageRequest.of(page - 1, size);
    Page<Department> all = departmentService.findAll(request);
    return ResultVOUtil.success(all);
  }

  /**
   * findAll
   *
   */
  @GetMapping("")
  public ResultVO findAll() throws InstantiationException, IllegalAccessException {
    List<Department> all = departmentService.findAll();
    return ResultVOUtil.success(all);
  }

  /**
   * findOne
   * @param id primary key
   * @return ResultVO
   */
  @GetMapping("/{id}")
  public ResultVO findOne(@PathVariable("id") Integer id){
    return ResultVOUtil.success(departmentService.findOne(id));
  }


  /**
   * add
   * @param data :ProcessDto pojo
   * @return ResultVO
   */
  @ResponseBody
  @PostMapping("")
  public ResultVO add(@Valid @RequestBody DepartmentForm data, BindingResult bindingResult){
    data.setId(null);
//    val user = (User) authenticationFacade.getAuthentication().getPrincipal();
    return save(null, data, bindingResult);
  }


  /**
   * update & save
   *
   * remark:
   *  throw new CoreException(ResultEnum.PARAM_ERROR.getCode(),
   *         bindingResult.getFieldError().getDefaultMessage());
   *
   * @param data :ProcessDto pojo
   * @return ResultVO
   */
  @ResponseBody
  @PostMapping("/{id}")
  public ResultVO save(@PathVariable("id") Integer id, @Valid @RequestBody DepartmentForm data, BindingResult bindingResult){

    data.setId(id);
    if (bindingResult.hasErrors()) {
      log.error("[rbac模块-部门]参数不正确, DepartmentForm={}", data);
      return ResultVOUtil.error(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
    }
//    val user = (User) authenticationFacade.getAuthentication().getPrincipal();
    val update = departmentService.update(data);
    return ResultVOUtil.success(update);
  }

  /**
   * delete
   * @param id :Process primary key
   * @return ResultVO
   *
   * remark: @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
   *
   */
  @DeleteMapping("/{id}")
  public ResultVO delete(@PathVariable("id") String id){
    return ResultVOUtil.result(departmentService.delete(id, new ResponseResult()));
  }






}
