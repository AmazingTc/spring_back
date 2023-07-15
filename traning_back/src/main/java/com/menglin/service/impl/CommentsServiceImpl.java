package com.menglin.service.impl;

import com.menglin.dao.CommentsDao;
import com.menglin.entity.Comments;
import com.menglin.service.CommentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Resource
    private CommentsDao commentsDao;

    @Override
    public List<Comments> getCommentsByBookId(Integer book_id) {
        return commentsDao.getCommentsByBookId(book_id);
    }

    @Override
    public int insertComments(Integer book_id, String nickname, String comments, String datetime) {
        return commentsDao.insertComments(book_id,nickname,comments,datetime);
    }
}
