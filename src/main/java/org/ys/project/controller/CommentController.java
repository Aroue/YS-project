package org.ys.project.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ys.utils.controller.APIController;

@RestController
@CrossOrigin
@Api(value = "养生论坛-评论")
@RequestMapping("/Comment")
public class CommentController extends APIController {
}
