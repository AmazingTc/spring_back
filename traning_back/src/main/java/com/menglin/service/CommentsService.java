package com.menglin.service;

import com.menglin.entity.Comments;

import java.util.List;

public interface CommentsService {

    // 根据书的ID查询相关评论
    List<Comments> getCommentsByBookId(Integer book_id);

    // 发送评论
    int insertComments(Integer book_id,String nickname,String comments,String datetime);
}
