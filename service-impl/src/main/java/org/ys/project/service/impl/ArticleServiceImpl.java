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
    public List<Article> getAll() {
        return null;
    }

    @Override
    public Article get(Integer id) {
        return null;
    }

    @Override
    public Boolean create(Article user) {
        return null;
    }

    @Override
    public Boolean edit(Article user) {
        return null;
    }

    @Override
    public Boolean delete(Article user) {
        return null;
    }
}
