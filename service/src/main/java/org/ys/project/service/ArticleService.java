package org.ys.project.service;

import org.ys.project.entity.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getAllArticle();

    Article getArticle(Integer id);

    Boolean addArticle(Article article);

    Boolean updateArticle(Article article);

    Boolean deleteArticle(Integer id);

    Boolean deleteArticleByUserId(Integer id);

    List<Article> selectArticleByTypeId(Integer id);

    List<Article> selectArticleByUserId(Integer id);

}
