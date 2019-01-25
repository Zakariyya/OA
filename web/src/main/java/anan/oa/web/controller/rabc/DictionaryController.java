package anan.oa.web.controller.rabc;

import anan.base.core.enums.ResultEnum;
import anan.base.core.orm.ResponseResult;
import anan.base.core.util.ResultVOUtil;
import anan.base.core.vo.ResultVO;
import anan.oa.rbac.orm.Dictionary;
import anan.oa.rbac.service.DictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/dict")
@Slf4j
public class DictionaryController {

  @Autowired
  private DictionaryService dictionaryService;

  /**
   * findAll
   * @return ResultVO<Dictionary2DictionaryDto>
   */
  @GetMapping("")
  public ResultVO findAll(){
    List<Dictionary> all = dictionaryService.findAll();
    return ResultVOUtil.success(all);
  }

  /**
   * findOne
   * @param id primary key
   * @return ResultVO
   */
  @GetMapping("/{id}")
  public ResultVO findOne(@PathVariable("id") Integer id){
    return ResultVOUtil.success(dictionaryService.findOne(id));
  }


  /**
   * add
   * @param data :DictionaryDto pojo
   * @return ResultVO
   */
  @ResponseBody
  @PostMapping("")
  public ResultVO add(@Valid @RequestBody Dictionary data, BindingResult bindingResult){
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
   * @param data :DictionaryDto pojo
   * @return ResultVO
   */
  @ResponseBody
  @PutMapping("/{id}")
  public ResultVO save(@PathVariable("id") Integer id, @Valid @RequestBody Dictionary data, BindingResult bindingResult){
    data.setId(id);
    if (bindingResult.hasErrors()) {
      log.error("[rbac模块-字典]参数不正确, Dictionary={}", data);
      return ResultVOUtil.error(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
    }
    Dictionary update = dictionaryService.update(data);
    return ResultVOUtil.success(update);
  }

  /**
   * delete
   * @param id :Dictionary primary key
   * @return ResultVO
   *
   * remark: @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
   *
   */
  @DeleteMapping("/{id}")
  public ResultVO delete(@PathVariable("id") String id){
    return ResultVOUtil.result(dictionaryService.delete(id, new ResponseResult()));
  }





}
