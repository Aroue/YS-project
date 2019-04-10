package org.ys.project.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.ys.project.dto.Article.*;
import org.ys.project.entity.Article;
import org.ys.project.service.ArticleService;
import org.ys.utils.BeanMapper;
import org.ys.utils.JSONResult;
import org.ys.utils.Message;
import org.ys.utils.controller.APIController;
import org.ys.utils.exception.BusinessException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@Api(value = "养生论坛-文章类型")
@RequestMapping("/Article")
public class ArticleController extends APIController {

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @ApiOperation(value = "获取全部文章", notes = "获取全部文章", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JSONResult A01() {
        JSONResult<List<ArticleBaseDTO>> jsonResult = new JSONResult<>();
        List<ArticleBaseDTO> articleBaseDTOList = BeanMapper.mapList(articleService.getAllArticle(),ArticleBaseDTO.class);

        jsonResult.setData(articleBaseDTOList);
        return jsonResult;
    }

    @ApiOperation(value = "添加文章", notes = "添加文章", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A02")
    public JSONResult A02(@Valid @RequestBody ArticleA02InputDTO input) throws BusinessException {
        JSONResult jsonResult = new JSONResult<>();
        Article article = BeanMapper.map(input, Article.class);
        boolean success = articleService.addArticle(article);

        if (success)
            jsonResult.setMessage(new Message("CM.DB.CREATE_SUCCESS", "文章"));
        else
            throw new BusinessException(new Message("CM.DB.CREATE_FAILED", "文章"));
        return jsonResult;
    }

    @ApiOperation(value = "修改文章", notes = "修改文章", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A03")
    public JSONResult A03(@Valid @RequestBody ArticleA03InputDTO input) throws BusinessException {
        JSONResult jsonResult = new JSONResult<>();
        Article article = BeanMapper.map(input, Article.class);
        boolean success = articleService.updateArticle(article);

        if (success)
            jsonResult.setMessage(new Message("CM.DB.UPDATE_SUCCESS", "文章"));
        else
            throw new BusinessException(new Message("CM.DB.UPDATE_FAILED", "文章"));
        return jsonResult;
    }

    @ApiOperation(value = "删除文章", notes = "删除文章", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A04")
    public JSONResult A04(@Valid @RequestBody ArticleA04InputDTO input) throws BusinessException {
        JSONResult jsonResult = new JSONResult<>();
        boolean success = articleService.deleteArticle(input.getId());

        if (success)
            jsonResult.setMessage(new Message("CM.DB.DELETE_SUCCESS", "文章"));
        else
            throw new BusinessException(new Message("CM.DB.DELETE_FAILED", "文章"));
        return jsonResult;
    }

    @ApiOperation(value = "获取某分类的全部文章", notes = "获取某分类的全部文章", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A05")
    public JSONResult A05(@Valid @RequestBody ArticleA05InputDTO input) {
        JSONResult<List<ArticleBaseDTO>> jsonResult = new JSONResult<>();
        List<ArticleBaseDTO> articleBaseDTOList = BeanMapper.mapList(articleService.selectArticleByTypeId(input.getTypeId()),ArticleBaseDTO.class);

        jsonResult.setData(articleBaseDTOList);
        return jsonResult;
    }

    @ApiOperation(value = "获取某用户的全部文章", notes = "获取某用户的全部文章", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A06")
    public JSONResult A06(@Valid @RequestBody ArticleA06InputDTO input) {
        JSONResult<List<ArticleBaseDTO>> jsonResult = new JSONResult<>();
        List<ArticleBaseDTO> articleBaseDTOList = BeanMapper.mapList(articleService.selectArticleByUserId(input.getUserId()),ArticleBaseDTO.class);

        jsonResult.setData(articleBaseDTOList);
        return jsonResult;
    }

    @ApiOperation(value = "删除某用户文章", notes = "删除某用户文章", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A07")
    public JSONResult A07(@Valid @RequestBody ArticleA06InputDTO input) throws BusinessException {
        JSONResult jsonResult = new JSONResult<>();
        boolean success = articleService.deleteArticleByUserId(input.getUserId());

        if (success)
            jsonResult.setMessage(new Message("CM.DB.DELETE_SUCCESS", "文章"));
        else
            throw new BusinessException(new Message("CM.DB.DELETE_FAILED", "文章"));
        return jsonResult;
    }

}
