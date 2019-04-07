package org.ys.project.service.impl;

import org.ys.project.dao.mapper.ArticleTypeMapper;
import org.ys.project.entity.ArticleType;
import org.ys.project.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component()
@Transactional
public class ArticleTypeServiceImpl implements ArticleTypeService {
    private final ArticleTypeMapper articleTypeMapper;

    @Autowired
    public ArticleTypeServiceImpl(ArticleTypeMapper articleTypeMapper) {
        this.articleTypeMapper = articleTypeMapper;
    }

    @Override
    public List<ArticleType> getAll() {
        return null;
    }

    @Override
    public ArticleType get(Integer id) {
        return null;
    }

    @Override
    public Boolean create(ArticleType user) {
        return null;
    }

    @Override
    public Boolean edit(ArticleType user) {
        return null;
    }

    @Override
    public Boolean delete(ArticleType user) {
        return null;
    }
}
