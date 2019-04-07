package org.ys.project.service.impl;

import org.ys.project.dao.mapper.CommentMapper;
import org.ys.project.entity.Comment;
import org.ys.project.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }


    @Override
    public List<Comment> getAll() {
        return null;
    }

    @Override
    public Comment get(Integer id) {
        return null;
    }

    @Override
    public Boolean create(Comment user) {
        return null;
    }

    @Override
    public Boolean edit(Comment user) {
        return null;
    }

    @Override
    public Boolean delete(Comment user) {
        return null;
    }
}
