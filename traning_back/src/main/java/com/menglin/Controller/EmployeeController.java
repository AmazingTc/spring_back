package com.menglin.Controller;
import com.menglin.Message.RequestCode;
import com.menglin.Message.Result;
import com.menglin.entity.Complete;
import com.menglin.entity.Employee;
import com.menglin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET)
    public Result getBookList() {
        List<Employee> t = employeeService.getAllEmployee();
        List<Employee> result = new ArrayList<Employee>();
        for (Employee e : t) {
            Complete c = employeeService.complete(e.getEmployee_id(), e.getTraning_id());
            if(c.getComplete()==1){
               e.setComplete(true);
            }else{
                e.setComplete(false);
            }
            result.add(e);
        }

        return new Result(RequestCode.SUCCESS, result);
    }

    @RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT)
    public Result updateBook(@RequestBody Employee e) {
        int i = employeeService.updateEmployee(e.getEmployee_id(),e.getEmployee_name(),e.getEmployee_age(),e.getTraning_id(),e.getEmployee_address(),e.getEmployee_phone(),e.getEmployee_sex());
        Result result = null;
        if (i != 0) {
            result = new Result(RequestCode.SUCCESS, i);
        } else {
            result = new Result(RequestCode.FAILURE, 0);
        }
        return result;
    }
    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
    public Result deleteTraning(@RequestParam(value = "id") Integer id) {
        Result result = null;
        int i = employeeService.deleteEmployee(id);
        if (i > 0) {
            result = new Result(RequestCode.SUCCESS, "删除成功");
        } else {
            result = new Result(RequestCode.SUCCESS, "删除失败");
        }
        return result;
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public Result insertBook(
                            @RequestParam(value = "employee_id") Integer id,
                             @RequestParam(value = "employee_name") String name,
                             @RequestParam(value = "employee_age") Integer age,
                             @RequestParam(value = "traning_id") Integer tId,
                             @RequestParam(value = "employee_address") String address,
                             @RequestParam(value = "employee_phone") String phone,
                             @RequestParam(value = "employee_sex") String sex
                             ) {
        System.out.println(id+name+age+tId+address+phone+sex);
        int t = employeeService.insertEmployee(id,name, age, tId, address, phone,sex);
        int r=employeeService.addComplete(id,tId,0);
        Result result = null;
        if (t > 0&&r>0) {
            result = new Result(RequestCode.SUCCESS, "添加成功");
        } else {
            result = new Result(RequestCode.SUCCESS, "添加失败");
        }
        return result;
    }

    @RequestMapping(value = "/complete", method = RequestMethod.POST)
    public Result complete(@RequestParam(value = "employee_id") Integer id,
                           @RequestParam(value = "traning_id") Integer tId
                           ) {
        Result result = null;
        Complete c = employeeService.complete(id,tId);

        result=new Result(RequestCode.SUCCESS, c);
        return result;
    }


    @RequestMapping(value = "/updateComplete", method = RequestMethod.POST)
    public Result updateComplete(@RequestParam(value = "employee_id") Integer id,
                                @RequestParam(value = "traning_id") Integer tId,
                                 @RequestParam(value = "complete") Integer complete
    ) {
        Result result = null;
        Integer r = employeeService.updateComplete(id,tId,complete);
        if(r>0){
            result=new Result(RequestCode.SUCCESS, "更新成功");
        }else{
            result=new Result(RequestCode.FAILURE, "更新失败");
        }
        return result;
    }

}
