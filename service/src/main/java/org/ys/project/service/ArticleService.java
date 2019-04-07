package org.ys.project.service;

import org.ys.project.entity.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getAll();
    Article get(Integer id);
    Boolean create(Article user);
    Boolean edit(Article user);
    Boolean delete(Article user);

}
