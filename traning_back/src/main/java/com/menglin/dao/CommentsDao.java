package com.menglin.dao;

import com.menglin.entity.Comments;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentsDao {

    @Select("select id,nickname,comments,datetime from comments where book_id = #{book_id}")
    List<Comments> getCommentsByBookId(Integer book_id);

    @Insert("insert into comments(book_id,nickname,comments,datetime) values(#{book_id},#{nickname},#{comments},#{datetime})")
    int insertComments(Integer book_id,String nickname,String comments,String datetime);


}
