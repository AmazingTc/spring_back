package com.menglin.service;

import com.menglin.entity.Traning;

import java.util.List;

public interface TranningService {
    List<Traning> getAllTraning();
    int deleteTraning(Integer id);
    Traning getTraningById(Integer id);
    Traning getTraningByTranId(Integer id);
    int insertTraning(Integer traning_id, String traning_program, String traning_data ,Integer traning_personnum,String traning_address);
    int updateTraning(Integer id, Integer traning_id, String traning_program, String traning_data, Integer traning_personnum, String traning_address);
}
