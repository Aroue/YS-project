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
    public List<Comment> getAllComment() {
        return commentMapper.selectAll();
    }

    @Override
    public Comment getComment(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean addComment(Comment comment) {
        return commentMapper.insert(comment) > 0;
    }

    @Override
    public Boolean deleteComment(Integer id) {
        return commentMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<Comment> getArticleComments(Integer id) {
        return commentMapper.getArticleComments(id);
    }
}
