package org.ys.project.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ys.project.dto.Comment.CommentA02InputDTO;
import org.ys.project.dto.Comment.CommentA03InputDTO;
import org.ys.project.dto.Comment.CommentA04InputDTO;
import org.ys.project.dto.Comment.CommentBaseDTO;
import org.ys.project.dto.User.UserA04A05InputDTO;
import org.ys.project.entity.Comment;
import org.ys.project.service.CommentService;
import org.ys.utils.BeanMapper;
import org.ys.utils.JSONResult;
import org.ys.utils.Message;
import org.ys.utils.controller.APIController;
import org.ys.utils.exception.BusinessException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@Api(value = "养生论坛-评论")
@RequestMapping("/Comment")
public class CommentController extends APIController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @ApiOperation(value = "获取全部评论", notes = "获取全部评论", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JSONResult A01() {
        JSONResult<List<CommentBaseDTO>> jsonResult = new JSONResult<>();
        List<CommentBaseDTO> commentBaseDTOList = BeanMapper.mapList(commentService.getAllComment(),CommentBaseDTO.class);

        jsonResult.setData(commentBaseDTOList);
        return jsonResult;
    }

    @ApiOperation(value = "获取某文章全部评论", notes = "获取某文章全部评论", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A02")
    public JSONResult A02(@Valid CommentA02InputDTO input) {
        JSONResult<List<CommentBaseDTO>> jsonResult = new JSONResult<>();
        List<CommentBaseDTO> commentBaseDTOList = BeanMapper.mapList(commentService.getArticleComments(input.getArticleId()),CommentBaseDTO.class);

        jsonResult.setData(commentBaseDTOList);
        return jsonResult;
    }

    @ApiOperation(value = "添加评论", notes = "添加评论", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A03")
    public JSONResult A03(@Valid CommentA03InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        Comment comment = BeanMapper.map(input,Comment.class);
        boolean success = commentService.addComment(comment);

        if (success)
            jsonResult.setMessage(new Message("CM.DB.CREATE_SUCCESS", "评论"));
        else
            throw new BusinessException(new Message("CM.DB.CREATE_FAILED", "评论"));

        return jsonResult;
    }

    @ApiOperation(value = "删除评论", notes = "删除评论", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A04")
    public JSONResult A04(@Valid CommentA04InputDTO input) throws BusinessException {
        JSONResult jsonResult = new JSONResult<>();
        boolean success = commentService.deleteComment(input.getId());

        if (success)
            jsonResult.setMessage(new Message("CM.DB.DELETE_SUCCESS", "评论"));
        else
            throw new BusinessException(new Message("CM.DB.DELETE_FAILED", "评论"));
        return jsonResult;
    }

}
