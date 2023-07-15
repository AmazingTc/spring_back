package com.menglin.Controller;

import com.menglin.Message.RequestCode;
import com.menglin.Message.Result;
import com.menglin.entity.Traning;
import com.menglin.service.TranningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class TraningController {
    @Autowired
    private TranningService tranningService;
    @RequestMapping(value = "/getAllTraning", method = RequestMethod.GET)
    public Result getBookList() {
        List<Traning> t = tranningService.getAllTraning();
        Result result = new Result(RequestCode.SUCCESS, t);
        return result;
    }
    @RequestMapping(value = "/getTranById", method = RequestMethod.POST)
    public Result getTranById(@RequestParam(value = "traning_id") Integer id) {
        System.out.println("id:"+id);
        Traning t = tranningService.getTraningByTranId(id);
        Result result = new Result(RequestCode.SUCCESS, t.getTraning_program());
        return result;
    }
    @RequestMapping(value = "/updateTraning", method = RequestMethod.PUT)
    public Result updateBook(@RequestBody Traning t) {
        int i = tranningService.updateTraning(t.getId(), t.getTraning_id(), t.getTraning_program(), t.getTraning_data(), t.getTraning_personnum(), t.getTraning_address());
        Result result = null;
        if (i != 0) {
            result = new Result(RequestCode.SUCCESS, i);
        } else {
            result = new Result(RequestCode.FAILURE, 0);
        }
        return result;
    }
    @RequestMapping(value = "/deleteTraning", method = RequestMethod.DELETE)
    public Result deleteTraning(@RequestParam(value = "id") Integer id) {
        Result result = null;

        int i = tranningService.deleteTraning(id);
        if (i > 0) {
            result = new Result(RequestCode.SUCCESS, "删除成功");
        } else {
            result = new Result(RequestCode.SUCCESS, "删除失败");
        }
        return result;
    }
    @RequestMapping(value = "/addTraning", method = RequestMethod.POST)
    public Result insertBook(@RequestParam(value = "traning_id") Integer id,
                             @RequestParam(value = "traning_program") String program,
                             @RequestParam(value = "traning_data") String date,
                             @RequestParam(value = "traning_address") String address,
                             @RequestParam(value = "traning_personnum") Integer num) {
        int t = tranningService.insertTraning(id, program, date, num, address);
        Result result = null;
        if (t > 0) {
            result = new Result(RequestCode.SUCCESS, "添加成功");
        } else {
            result = new Result(RequestCode.SUCCESS, "添加失败");
        }
        return result;
    }
}
