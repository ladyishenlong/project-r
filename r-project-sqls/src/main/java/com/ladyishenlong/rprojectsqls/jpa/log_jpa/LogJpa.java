package com.ladyishenlong.rprojectsqls.jpa.log_jpa;

import com.ladyishenlong.rprojectsqls.model.log_model.LogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019-05-31 16:28
 */
@Repository
public interface LogJpa extends JpaRepository<LogModel, Integer> {

    List<LogModel> findAll();
}
