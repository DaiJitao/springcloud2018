package com.atguigu.springcloud.service.Impl;

import com.atguigu.springcloud.dao.CommentDao;
import com.atguigu.springcloud.entities.Comment;
import com.atguigu.springcloud.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:hejr
 * @Description:
 * @Date: 2019/3/25 10:11
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao dao;

    @Override
    public boolean add(Comment comment) {
        return dao.addComment(comment);
    }

    @Override
    public Comment get(Long id) {
        return null;
    }

    @Override
    public List<Comment> list() {
        return dao.findAll();
    }

    @Override
    public List<Comment> findAll() {
        return dao.findAll();
    }
}
