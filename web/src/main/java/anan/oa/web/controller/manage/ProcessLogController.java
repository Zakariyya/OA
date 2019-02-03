package anan.oa.web.controller.manage;

import anan.base.core.enums.ResultEnum;
import anan.base.core.orm.ResponseResult;
import anan.base.core.util.ResultVOUtil;
import anan.base.core.vo.ResultVO;
import anan.oa.manage.converter.Process2ProcessDto;
import anan.oa.manage.dto.ProcessDto;
import anan.oa.manage.form.ProcessForm;
import anan.oa.manage.orm.Process;
import anan.oa.manage.orm.ProcessLog;
import anan.oa.manage.service.ProcessLogService;
import anan.oa.manage.service.ProcessService;
import anan.oa.rbac.orm.User;
import anan.oa.web.security.AuthenticationFacade;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * @author anan
 * Created on 2019/02/03.
 */
@RestController
@RequestMapping("/processlog")
@Slf4j
public class ProcessLogController {

  @Autowired
  private ProcessLogService processLogService;

  @Autowired
  private AuthenticationFacade authenticationFacade;



  /**
   * findAll by page
   * @return ResultVO<Category>
   */
  @GetMapping("/{page}/{size}")
  public ResultVO findAll(@PathVariable(value = "page") Integer page,
                          @PathVariable(value = "size") Integer size) {
    PageRequest request = PageRequest.of(page - 1, size);
    Page<ProcessLog> all = processLogService.findAll(request);
    return ResultVOUtil.success(all);
  }

  /**
   * findAll
   *
   */
  @GetMapping("")
  public ResultVO findAll() throws InstantiationException, IllegalAccessException {
    List<ProcessLog> all = processLogService.findAll();
      return ResultVOUtil.success(all);
  }

  /**
   * findOne
   * @param id primary key
   * @return ResultVO
   */
  @GetMapping("/{id}")
  public ResultVO findOne(@PathVariable("id") Integer id){
    return ResultVOUtil.success(processLogService.findOne(id));
  }

}
