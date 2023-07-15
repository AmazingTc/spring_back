package com.menglin.service;

import com.menglin.entity.Complete;
import com.menglin.entity.Employee;
import com.menglin.entity.Traning;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    int deleteEmployee(Integer id);
    Employee getEmployeeById(Integer id);
    int insertEmployee(Integer id,String employee_name, Integer employee_age ,Integer traning_id,String employee_address,String employee_phone,String employee_sex);
    int updateEmployee(Integer employee_Id, String employee_name, Integer employee_age ,Integer traning_id,String employee_address,String employee_phone,String employee_sex);
    Complete complete(Integer employee_id, Integer traning_id);
    int updateComplete(Integer employee_id, Integer traning_id,Integer c);
    int addComplete(Integer id,Integer tId,Integer c);

}
