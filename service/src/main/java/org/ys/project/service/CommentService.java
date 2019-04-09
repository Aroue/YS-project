package org.ys.project.service;

import org.ys.project.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getAllComment();

    Comment getComment(Integer id);

    Boolean addComment(Comment comment);

    Boolean deleteComment(Integer id);

    List<Comment> getArticleComments(Integer id);
}
