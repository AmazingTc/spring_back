package com.menglin.service.impl;

import com.menglin.dao.EmployeeDao;
import com.menglin.dao.TraningDao;
import com.menglin.entity.Complete;
import com.menglin.entity.Employee;
import com.menglin.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeDao employeeDao;
    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }

    @Override
    public int deleteEmployee(Integer id) {
        return employeeDao.deleteEmployee(id);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public int insertEmployee(Integer id,String employee_name, Integer employee_age, Integer traning_id, String employee_address, String employee_phone,String employee_sex) {
        return employeeDao.insertEmployee(id,employee_name,employee_age,traning_id,employee_address,employee_phone,employee_sex);
    }

    @Override
    public int updateEmployee(Integer employee_Id, String employee_name, Integer employee_age, Integer traning_id, String employee_address, String employee_phone,String employee_sex) {
        return employeeDao.updateEmployee(employee_Id,employee_name,employee_age,traning_id,employee_address,employee_phone,employee_sex);
    }

    @Override
    public Complete complete(Integer employee_id, Integer traning_id) {
        return employeeDao.complete(employee_id,traning_id);
    }

    @Override
    public int updateComplete(Integer employee_id, Integer traning_id,Integer c) {
        return employeeDao.updateComplete(employee_id,traning_id,c);
    }

    @Override
    public int addComplete(Integer id, Integer tId, Integer c) {
        return employeeDao.addComplete(id,tId,c);
    }

}
