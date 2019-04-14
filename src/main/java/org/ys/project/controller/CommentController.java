package org.ys.project.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.ys.project.dto.Comment.CommentA02InputDTO;
import org.ys.project.dto.Comment.CommentA03InputDTO;
import org.ys.project.dto.Comment.CommentA04InputDTO;
import org.ys.project.dto.Comment.CommentBaseDTO;
import org.ys.project.dto.User.UserA04A05InputDTO;
import org.ys.project.entity.Comment;
import org.ys.project.entity.User;
import org.ys.project.service.CommentService;
import org.ys.project.service.UserService;
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
    private UserService userService;

    public CommentController(CommentService commentService,UserService userService) {
        this.commentService = commentService;
        this.userService = userService;
    }

    @ApiOperation(value = "获取全部评论", notes = "获取全部评论", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JSONResult A01() {
        JSONResult<List<CommentBaseDTO>> jsonResult = new JSONResult<>();
        List<CommentBaseDTO> commentBaseDTOList = BeanMapper.mapList(commentService.getAllComment(),CommentBaseDTO.class);

        for (CommentBaseDTO item:commentBaseDTOList) {
            item.setNickName(userService.getUser(item.getUserId()).getNickName());
        }

        jsonResult.setData(commentBaseDTOList);
        return jsonResult;
    }

    @ApiOperation(value = "获取某文章全部评论", notes = "获取某文章全部评论", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A02")
    public JSONResult A02(@Valid @RequestBody CommentA02InputDTO input) {
        JSONResult<List<CommentBaseDTO>> jsonResult = new JSONResult<>();
        List<CommentBaseDTO> commentBaseDTOList = BeanMapper.mapList(commentService.getArticleComments(input.getArticleId()),CommentBaseDTO.class);

        commentBaseDTOList.forEach(item -> item.setNickName(BeanMapper.map(userService.getUser(item.getUserId()),User.class).getNickName()));

        jsonResult.setData(commentBaseDTOList);
        return jsonResult;
    }

    @ApiOperation(value = "添加评论", notes = "添加评论", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A03")
    public JSONResult A03(@Valid @RequestBody CommentA03InputDTO input) {
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
    public JSONResult A04(@Valid @RequestBody CommentA04InputDTO input) throws BusinessException {
        JSONResult jsonResult = new JSONResult<>();
        boolean success = commentService.deleteComment(input.getId());

        if (success)
            jsonResult.setMessage(new Message("CM.DB.DELETE_SUCCESS", "评论"));
        else
            throw new BusinessException(new Message("CM.DB.DELETE_FAILED", "评论"));
        return jsonResult;
    }

}
