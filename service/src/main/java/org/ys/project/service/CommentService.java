package org.ys.project.service;

import org.ys.project.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getAll();
    Comment get(Integer id);
    Boolean create(Comment user);
    Boolean edit(Comment user);
    Boolean delete(Comment user);
}
