package org.ys.project.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ys.project.dto.User.UserA02InputDTO;
import org.ys.project.dto.User.UserA01DTO;
import org.ys.project.dto.User.UserA03InputDTO;
import org.ys.project.dto.User.UserA04A05InputDTO;
import org.ys.project.entity.User;
import org.ys.project.service.UserService;
import org.ys.utils.BeanMapper;
import org.ys.utils.JSONResult;
import org.springframework.http.MediaType;
import org.ys.utils.Message;
import org.ys.utils.controller.APIController;
import org.ys.utils.exception.BusinessException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@Api(value = "养生论坛-用户")
@RequestMapping("/User")
public class UserController extends APIController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "获取全部用户", notes = "获取全部用户信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JSONResult A01() {
        JSONResult<List<UserA01DTO>> jsonResult = new JSONResult<>();
        List<UserA01DTO> userA01DTOList = BeanMapper.mapList(userService.getAllUser(), UserA01DTO.class);

        jsonResult.setData(userA01DTOList);
        return jsonResult;
    }

    @ApiOperation(value = "新增用户", notes = "新增用户，用户注册", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A02")
    public JSONResult A02(@Valid UserA02InputDTO input) throws BusinessException {
        JSONResult jsonResult = new JSONResult<>();
        User user = BeanMapper.map(input, User.class);
        boolean success = userService.addUser(user);

        if (success)
            jsonResult.setMessage(new Message("CM.DB.CREATE_SUCCESS", "用户"));
        else
            throw new BusinessException(new Message("CM.DB.CREATE_FAILED", "用户"));
        return jsonResult;
    }

    @ApiOperation(value = "用户信息更新", notes = "用户信息更新", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A03")
    public JSONResult A03(@Valid UserA03InputDTO input) throws BusinessException {
        JSONResult jsonResult = new JSONResult<>();
        User user = BeanMapper.map(input, User.class);
        boolean success = userService.updateUser(user);

        if (success)
            jsonResult.setMessage(new Message("CM.DB.UPDATE_SUCCESS", "用户"));
        else
            throw new BusinessException(new Message("CM.DB.UPDATE_FAILED", "用户"));
        return jsonResult;
    }

    @ApiOperation(value = "删除用户", notes = "删除用户", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A04")
    public JSONResult A04(@Valid UserA04A05InputDTO input) throws BusinessException {
        JSONResult jsonResult = new JSONResult<>();
        boolean success = userService.deleteUser(input.getId());

        if (success)
            jsonResult.setMessage(new Message("CM.DB.DELETE_SUCCESS", "用户"));
        else
            throw new BusinessException(new Message("CM.DB.DELETE_FAILED", "用户"));
        return jsonResult;
    }

    @ApiOperation(value = "获取用户信息", notes = "获取用户信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A05")
    public JSONResult A05(@Valid UserA04A05InputDTO input) throws BusinessException {
        JSONResult<User> jsonResult = new JSONResult<>();
        User user = userService.getUser(input.getId());

        if (user != null) {
            jsonResult.setData(user);
        } else {
            throw new BusinessException(new Message("CM.DB.NO_RESULT", "用户"));
        }
        return jsonResult;
    }

}
