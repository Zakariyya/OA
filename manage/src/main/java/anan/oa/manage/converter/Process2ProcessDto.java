package anan.oa.manage.converter;

import anan.oa.manage.dto.ProcessDto;
import anan.oa.manage.orm.Process;
import anan.oa.manage.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;

/**
 * @author anan
 * Created on 2018/8/22.
 *
 * note:
   * question:
   *  in the Component under Autowired's bean is null,
   *
   * solution:
   *  https://blog.csdn.net/georgeshaw1/article/details/74943089 (source)
   *  https://zakariyya.github.io/2018/08/23/backEnd/spring/springboot-Component%E4%B8%8B-Autowired%E7%9A%84%E6%B3%A8%E5%85%A5%E4%B8%BAnull/#%E8%83%8C%E6%99%AF  (backup)
   *  https://zakariyya.github.io/2018/08/23/backEnd/spring/springboot-Component下-Autowired的注入为null/#背景  (backup)
 *
 */
@Component
public class Process2ProcessDto {

  @Autowired
  protected ProcessService service;
  private static Process2ProcessDto  p2p ;
  @PostConstruct //通过@PostConstruct实现初始化bean之前进行的操作
  public void init() {
    p2p = this;
    p2p.service = this.service;
    // 初使化时将已静态化的testService实例化
  }

  public ProcessDto convert(Process data) {
    ProcessDto dto = new ProcessDto();
    dto.setName(data.getName());
    dto.setType(data.getScheduleId().getOptionValue());
    dto.setSchedule(data.getScheduleId().getOptionValue());
//    dto.setProcessTime(data.getProcessTime().getOptionValue());
    dto.setRemark(data.getRemark());
    dto.setCreateTime(Timestamp.valueOf(data.getCreateTime().toString()).getTime());//都一样的
    dto.setUpdateTime(data.getUpdateTime().getTime());//都一样的
    return dto;
  }


}
