package org.ys.project.service;

import org.ys.project.entity.ArticleType;

import java.util.List;

public interface ArticleTypeService {

    List<ArticleType> getAll();
    ArticleType get(Integer id);
    Boolean create(ArticleType user);
    Boolean edit(ArticleType user);
    Boolean delete(ArticleType user);
}
