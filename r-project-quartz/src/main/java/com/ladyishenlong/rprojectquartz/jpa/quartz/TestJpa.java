package com.ladyishenlong.rprojectquartz.jpa.quartz;

import com.ladyishenlong.rprojectquartz.model.quartz.TestTable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author ruanchenhao
 * @Date 2019/9/12 4:31 下午
 */
public interface TestJpa  extends JpaRepository<TestTable,Integer> {

}
