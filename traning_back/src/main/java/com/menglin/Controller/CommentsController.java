package com.menglin.Controller;

import com.menglin.Message.RequestCode;
import com.menglin.Message.Result;
import com.menglin.Utils.dateUtil;
import com.menglin.entity.Comments;
import com.menglin.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @RequestMapping(value = "/comments",method = RequestMethod.GET)
    public Result getCommentsList(@RequestParam("book_id") Integer book_id){
        List<Comments> commentsList = commentsService.getCommentsByBookId(book_id);
        Result result = new Result(RequestCode.SUCCESS,commentsList);
        return result;
    }


    @RequestMapping(value = "/comments",method = RequestMethod.POST)
    public Result insertComments(@RequestBody Comments comments){
        comments.setDatetime(dateUtil.getDateTime());
        Result result = null;
        int i = commentsService.insertComments(comments.getBook_id(), comments.getNickname(), comments.getComments(), comments.getDatetime());
        System.out.println("["+comments.getDatetime()+"]"+comments.getNickname()+" : "+comments.getComments());
        if (i == 1){
            result = new Result(RequestCode.SUCCESS,comments);
        }else {
            result = new Result(RequestCode.FAILURE,"评论失败");
        }
        return result;
    }


}
