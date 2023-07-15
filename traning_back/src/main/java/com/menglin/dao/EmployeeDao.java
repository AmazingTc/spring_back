package com.menglin.dao;

import com.menglin.entity.Complete;
import com.menglin.entity.Employee;
import com.menglin.entity.Traning;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeDao {
    @Select("select * from employee")
    List<Employee> getAllEmployee();
    @Delete("delete from employee where employee_Id = #{id}")
    int deleteEmployee(Integer id);
    @Select("select * from employee where employee_Id = #{id}")
    Employee getEmployeeById(Integer id);
    @Update("update employee set employee_name=#{name},employee_age=#{age},traning_id=#{tId},employee_address=#{address},employee_phone=#{phone},employee_sex=#{sex} where employee_Id=#{id}")
    int updateEmployee(Integer id, String name, Integer age, Integer tId,String address,String phone,String sex);
    @Insert("insert into employee(employee_id,employee_name,employee_age,traning_id,employee_address,employee_phone,employee_sex) values(#{id},#{name},#{age},#{tId},#{address},#{phone},#{sex})")
    int insertEmployee(Integer id,String name, Integer age, Integer tId, String address, String phone,String sex);

    @Select("select * from complete where employee_Id=#{employee_id} and traning_id=#{traning_id}")
    Complete complete(Integer employee_id, Integer traning_id);
    @Update("update complete set complete=#{complete} where employee_Id=#{employee_id} and traning_id=#{traning_id}")
    int updateComplete(Integer employee_id, Integer traning_id,Integer complete);
    @Insert("insert into complete(employee_id,traning_id,complete) values(#{id},#{tId},#{complete})")
    int addComplete(Integer id,Integer tId,Integer complete);
}
