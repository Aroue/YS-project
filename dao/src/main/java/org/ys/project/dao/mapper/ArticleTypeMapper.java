package org.ys.project.dao.mapper;

import org.ys.project.entity.Article;
import org.ys.project.entity.ArticleType;
import java.util.List;

public interface ArticleTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleType record);

    ArticleType selectByPrimaryKey(Integer id);

    List<ArticleType> selectAll();

    int updateByPrimaryKey(ArticleType record);

}
