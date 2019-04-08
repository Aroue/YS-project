package org.ys.project.dao.mapper;

import org.ys.project.entity.Article;
import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    Article selectByPrimaryKey(Integer id);

    List<Article> selectAll();

    int updateByPrimaryKey(Article record);

    int deleteArticleByUserId(Integer id);

    List<Article> selectArticleByTypeId(Integer id);

    List<Article> selectArticleByUserId(Integer id);
}
