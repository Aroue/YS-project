package org.ys.project.service;

import org.ys.project.entity.ArticleType;

import java.util.List;

public interface ArticleTypeService {

    List<ArticleType> getAllArticleType();

    ArticleType getArticleType(Integer id);

    Boolean addArticleType(ArticleType articleType);

    Boolean updateArticleType(ArticleType articleType);

    Boolean deleteArticleType(Integer id);
}
