package com.menglin.service.impl;

import com.menglin.dao.TraningDao;
import com.menglin.entity.Traning;
import com.menglin.service.TranningService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TraningServiceImpl implements TranningService {
    @Resource
    private TraningDao tranDao;
    @Override
    public List<Traning> getAllTraning() {
        return tranDao.getAllTraning();
    }

    @Override
    public int deleteTraning(Integer id) {
        return tranDao.deleteTraning(id);
    }

    @Override
    public Traning getTraningById(Integer id) {
        return tranDao.getTraningById(id);
    }

    @Override
    public Traning getTraningByTranId(Integer id) {
         return tranDao.getTraningByTranId(id);
    }

    @Override
    public int insertTraning(Integer traning_id, String traning_program, String traning_data, Integer traning_personnum, String traning_address) {
        return tranDao.insertTraning(traning_id,traning_program,traning_data,traning_personnum,traning_address);
    }

    @Override
    public int updateTraning(Integer id, Integer traning_id, String traning_program, String traning_data, Integer traning_personnum, String traning_address) {
        return tranDao.updateTraning(id,traning_id,traning_program,traning_data,traning_personnum,traning_address);
    }
}
