package org.ys.project.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ys.project.dto.User.UserA02InputDTO;
import org.ys.project.dto.User.UserA01DTO;
import org.ys.project.dto.User.UserA03InputDTO;
import org.ys.project.entity.User;
import org.ys.project.service.UserService;
import org.ys.utils.BeanMapper;
import org.ys.utils.JSONResult;
import org.springframework.http.MediaType;
import org.ys.utils.controller.APIController;
import org.ys.utils.exception.BusinessException;

import javax.validation.Valid;
import java.util.List;

@RestController
//@CrossOrigin
@Api("养生论坛-用户")
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
        List<UserA01DTO> userA01DTOList =  BeanMapper.mapList(userService.getAllUser(),UserA01DTO.class);

        jsonResult.setData(userA01DTOList);
        return jsonResult;
    }

    @ApiOperation(value = "新增用户", notes = "新增用户，用户注册", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A02")
    public JSONResult A02(@Valid UserA02InputDTO input) throws BusinessException {
        JSONResult jsonResult = new JSONResult<>();
        User user = BeanMapper.map(input,User.class);
        boolean success  = userService.addUser(user);

        jsonResult.setMessage(success ? "success" : "failed");
        return jsonResult;
    }

    @ApiOperation(value = "用户信息更新", notes = "用户信息更新", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A03")
    public JSONResult A03(@Valid UserA03InputDTO input) {
        JSONResult jsonResult = new JSONResult<>();
        User user = BeanMapper.map(input,User.class);
        boolean success  = userService.updateUser(user);

        jsonResult.setMessage(success ? "success" : "failed");
        return jsonResult;
    }
}
