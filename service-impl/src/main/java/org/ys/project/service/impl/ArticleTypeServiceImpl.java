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
    public List<ArticleType> getAllArticleType() {
        return articleTypeMapper.selectAll();
    }

    @Override
    public ArticleType getArticleType(Integer id) {
        return articleTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean addArticleType(ArticleType articleType) {
        return articleTypeMapper.insert(articleType) > 0;
    }

    @Override
    public Boolean updateArticleType(ArticleType articleType) {
        return articleTypeMapper.updateByPrimaryKey(articleType) > 0;
    }

    @Override
    public Boolean deleteArticleType(Integer id) {
        return articleTypeMapper.deleteByPrimaryKey(id) > 0;
    }
}
