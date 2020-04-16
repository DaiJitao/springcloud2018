package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:hejr
 * @Description:
 * @Date: 2019/3/25 9:30
 */
@Mapper
public interface CommentDao {

    //@Delete("delete from comment_2_tb")
    public int deleteAll();

    //@Insert("INSERT INTO comment_2_tb(uid, newsId, post_time_str, post_time, post_loc, comment_context, is_new) " +
    //        " VALUES (#{uid}, #{newsId}, #{post_time_str}, #{post_time}, #{post_loc}, #{comment_context}, #{isNew});")
    public boolean addComment(Comment comment);

    public List<Comment> findAll();


    public List<Comment> findByUID(String uid);


    @Select("SELECT DISTINCT uid FROM comment_2_tb")
    public List<Comment> findAllUID();

}
