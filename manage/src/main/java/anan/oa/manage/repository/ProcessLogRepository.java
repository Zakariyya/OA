package anan.oa.manage.repository;

import anan.oa.manage.orm.ProcessLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author anan
 * @created 2019/1/22 11:52
 */

public interface ProcessLogRepository extends JpaRepository<ProcessLog, Integer> {

}
