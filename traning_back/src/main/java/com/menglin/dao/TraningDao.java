package com.menglin.dao;

import com.menglin.entity.Traning;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface TraningDao {
    @Select("select id,traning_id,traning_program,traning_data,traning_personnum,traning_address from traning")
    List<Traning> getAllTraning();
    @Delete("delete from traning where traning_id = #{id}")
    int deleteTraning(Integer id);
    @Select("select * from traning where id = #{id}")
    Traning getTraningById(Integer id);
    @Select("select * from traning where traning_Id = #{id}")
    Traning getTraningByTranId(Integer id);
    @Update("update traning set traning_id=#{traning_id},traning_program=#{traning_program},traning_data=#{traning_data},traning_personnum=#{traning_personnum},traning_address=#{traning_address} where id=#{id}")
    int updateTraning(Integer id, Integer traning_id, String traning_program, String traning_data, Integer traning_personnum, String traning_address);
    @Insert("insert into traning(traning_id,traning_program,traning_data,traning_personnum,traning_address) values(#{traning_id},#{traning_program},#{traning_data},#{traning_personnum},#{traning_address})")
    int insertTraning(Integer traning_id, String traning_program, String traning_data, Integer traning_personnum, String traning_address);
}
