package org.ys.project.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ys.project.dto.Article.*;
import org.ys.project.entity.Article;
import org.ys.project.service.ArticleService;
import org.ys.utils.BeanMapper;
import org.ys.utils.JSONResult;
import org.ys.utils.controller.APIController;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@Api(value = "养生论坛-文章类型")
@RequestMapping("/Article")
public class ArticleController extends APIController {

    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @ApiOperation(value = "获取全部文章", notes = "获取全部文章", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JSONResult A01() {
        JSONResult<List<Article>> jsonResult = new JSONResult<>();
        List<Article> articleList = articleService.getAllArticle();

        jsonResult.setData(articleList);
        return jsonResult;
    }

    @ApiOperation(value = "添加文章", notes = "添加文章", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A02")
    public JSONResult A02(@Valid ArticleA02InputDTO input) {
        JSONResult jsonResult = new JSONResult<>();
        Article article = BeanMapper.map(input, Article.class);
        boolean success = articleService.addArticle(article);

        if (success)
            jsonResult.setMessage("新增文章成功");
        return jsonResult;
    }

    @ApiOperation(value = "修改文章", notes = "修改文章", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A03")
    public JSONResult A03(@Valid ArticleA03InputDTO input) {
        JSONResult jsonResult = new JSONResult<>();
        Article article = BeanMapper.map(input, Article.class);
        boolean success = articleService.updateArticle(article);

        if (success)
            jsonResult.setMessage("修改文章成功");
        return jsonResult;
    }

    @ApiOperation(value = "删除文章", notes = "删除文章", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A04")
    public JSONResult A04(@Valid ArticleA04InputDTO input) {
        JSONResult jsonResult = new JSONResult<>();
        boolean success = articleService.deleteArticle(input.getId());

        if (success)
            jsonResult.setMessage("删除文章成功");
        return jsonResult;
    }

    @ApiOperation(value = "获取某分类的全部文章", notes = "获取某分类的全部文章", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A05")
    public JSONResult A05(@Valid ArticleA05InputDTO input) {
        JSONResult<List<Article>> jsonResult = new JSONResult<>();
        List<Article> articleList = articleService.selectArticleByTypeId(input.getTypeId());

        jsonResult.setData(articleList);
        return jsonResult;
    }

    @ApiOperation(value = "获取某用户的全部文章", notes = "获取某用户的全部文章", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A06")
    public JSONResult A06(@Valid ArticleA06InputDTO input) {
        JSONResult<List<Article>> jsonResult = new JSONResult<>();
        List<Article> articleList = articleService.selectArticleByUserId(input.getUserId());

        jsonResult.setData(articleList);
        return jsonResult;
    }
}
