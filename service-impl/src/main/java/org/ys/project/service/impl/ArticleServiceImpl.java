package org.ys.project.service.impl;

import org.ys.project.dao.mapper.ArticleMapper;
import org.ys.project.entity.Article;
import org.ys.project.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ArticleServiceImpl implements ArticleService {
    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleServiceImpl(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }


    @Override
    public List<Article> getAllArticle() {
        return articleMapper.selectAll();
    }

    @Override
    public Article getArticle(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean addArticle(Article article) {
        return articleMapper.insert(article) > 0;
    }

    @Override
    public Boolean updateArticle(Article article) {
        return articleMapper.updateByPrimaryKey(article) > 0;
    }

    @Override
    public Boolean deleteArticle(Integer id) {
        return articleMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<Article> selectArticleByTypeId(Integer id) {
        return articleMapper.selectArticleByTypeId(id);
    }

    @Override
    public List<Article> selectArticleByUserId(Integer id) {
        return articleMapper.selectArticleByUserId(id);
    }
}
