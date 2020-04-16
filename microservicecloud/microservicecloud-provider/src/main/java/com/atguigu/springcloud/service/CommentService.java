package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Comment;

import java.util.List;

public interface CommentService {
    public boolean add(Comment comment);
    public Comment get(Long id);
    public List<Comment> list();

    public List<Comment> findAll();
}
