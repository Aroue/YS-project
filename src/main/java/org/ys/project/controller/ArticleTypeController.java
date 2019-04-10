package org.ys.project.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.ys.project.dto.ArticleType.ArticleTypeA02InputDTO;
import org.ys.project.dto.ArticleType.ArticleTypeA03InputDTO;
import org.ys.project.dto.ArticleType.ArticleTypeA04InputDTO;
import org.ys.project.dto.ArticleType.ArticleTypeBaseDTO;
import org.ys.project.entity.ArticleType;
import org.ys.project.service.ArticleService;
import org.ys.project.service.ArticleTypeService;
import org.ys.utils.BeanMapper;
import org.ys.utils.JSONResult;
import org.ys.utils.Message;
import org.ys.utils.controller.APIController;
import org.ys.utils.exception.BusinessException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@Api(value = "养生论坛-文章")
@RequestMapping("/ArticleType")
public class ArticleTypeController extends APIController {

    private ArticleTypeService articleTypeService;

    private ArticleService articleService;

    @Autowired
    public ArticleTypeController(ArticleTypeService articleTypeService, ArticleService articleService) {
        this.articleTypeService = articleTypeService;
        this.articleService = articleService;
    }

    @ApiOperation(value = "获取全部文章类型", notes = "获取全部文章类型", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JSONResult A01() {
        JSONResult<List<ArticleTypeBaseDTO>> jsonResult = new JSONResult<>();
        List<ArticleTypeBaseDTO> articleTypeBaseDTOList = BeanMapper.mapList(articleTypeService.getAllArticleType(),ArticleTypeBaseDTO.class);

        jsonResult.setData(articleTypeBaseDTOList);
        return jsonResult;
    }

    @ApiOperation(value = "添加文章类型", notes = "添加文章类型", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A02")
    public JSONResult A02(@Valid @RequestBody ArticleTypeA02InputDTO input) throws BusinessException {
        JSONResult jsonResult = new JSONResult<>();
        ArticleType articleType = BeanMapper.map(input,ArticleType.class);
        boolean success = articleTypeService.addArticleType(articleType);

        if (success)
            jsonResult.setMessage(new Message("CM.DB.CREATE_SUCCESS", "文章类型"));
        else
            throw new BusinessException(new Message("CM.DB.CREATE_FAILED", "文章类型"));
        return jsonResult;
    }

    @ApiOperation(value = "修改文章类型", notes = "修改文章类型", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A03")
    public JSONResult A03(@Valid @RequestBody ArticleTypeA03InputDTO input) throws BusinessException {
        JSONResult jsonResult = new JSONResult<>();
        ArticleType articleType = BeanMapper.map(input,ArticleType.class);
        boolean success = articleTypeService.updateArticleType(articleType);

        if (success)
            jsonResult.setMessage(new Message("CM.DB.UPDATE_SUCCESS", "文章类型"));
        else
            throw new BusinessException(new Message("CM.DB.UPDATE_FAILED", "文章类型"));
        return jsonResult;
    }

    @ApiOperation(value = "删除文章类型", notes = "删除文章类型", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A04")
    public JSONResult A04(@Valid @RequestBody ArticleTypeA04InputDTO input) throws BusinessException {
        JSONResult jsonResult = new JSONResult<>();
        boolean deleteArticleType = articleTypeService.deleteArticleType(input.getId());
        boolean deleteArticle = articleService.deleteArticle(input.getId());

        if (deleteArticleType && deleteArticle)
            jsonResult.setMessage(new Message("CM.DB.DELETE_SUCCESS", "文章类型"));
        else
            throw new BusinessException(new Message("CM.DB.DELETE_FAILED", "文章类型"));
        return jsonResult;
    }
}
