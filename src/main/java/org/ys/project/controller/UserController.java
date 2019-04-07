package org.ys.project.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ys.project.entity.User;
import org.ys.project.service.UserService;
import org.ys.utils.JSONResult;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ys.utils.controller.APIController;

import java.util.List;

@RestController
//@CrossOrigin
@Api("用户相关API")
@RequestMapping("/user")
public class UserController extends APIController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "获取全部用户", notes = "获取全部用户", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public JSONResult users() {
        JSONResult<List<User>> jsonResult = new JSONResult<>();
        jsonResult.setData(userService.getAll());
        jsonResult.setMessage("success");
        return jsonResult;
    }
}
