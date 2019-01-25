package anan.oa.web.controller.manage;

import anan.base.core.enums.ResultEnum;
import anan.base.core.orm.ResponseResult;
import anan.oa.manage.converter.Process2ProcessDto;
import anan.oa.manage.dto.ProcessDto;
import anan.oa.manage.form.ProcessForm;
import anan.oa.manage.orm.Process;
import anan.base.core.util.ResultVOUtil;
import anan.base.core.vo.ResultVO;
import anan.oa.manage.service.ProcessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


/**
 * @author anan
 * Created on 2018/8/27.
 * Modify on 2018/12/26.
 */
@RestController
@RequestMapping("/process")
@Slf4j
public class ProcessController {

  @Autowired
  private ProcessService processService;

  @Autowired
  private Process2ProcessDto p2p;
  /**
   * findAll
   *
   */
  @GetMapping("")
  public ResultVO findAll(){
    List<Process> all = processService.findAll();
    List<ProcessDto> pdto = new ArrayList<>();
    for (Process item : all) {
      pdto.add(p2p.convert(item));
    }
    return ResultVOUtil.success(pdto);
  }

  /**
   * findOne
   * @param id primary key
   * @return ResultVO
   */
  @GetMapping("/{id}")
  public ResultVO findOne(@PathVariable("id") Integer id){
    return ResultVOUtil.success(processService.findOne(id));
  }


  /**
   * add
   * @param data :ProcessDto pojo
   * @return ResultVO
   */
  @ResponseBody
  @PostMapping("")
  public ResultVO add(@Valid @RequestBody ProcessForm data, BindingResult bindingResult){
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
   * @param data :ProcessDto pojo
   * @return ResultVO
   */
  @ResponseBody
  @PutMapping("/{id}")
  public ResultVO save(@PathVariable("id") Integer id, @Valid @RequestBody ProcessForm data, BindingResult bindingResult){
    data.setId(id);
    if (bindingResult.hasErrors()) {
      log.error("[manage模块-字典]参数不正确, Process={}", data);
      return ResultVOUtil.error(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
    }
    Process update = processService.update(data);
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
    return ResultVOUtil.result(processService.delete(id, new ResponseResult()));
  }





}
