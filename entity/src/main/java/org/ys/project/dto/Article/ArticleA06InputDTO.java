package org.ys.project.dto.Article;

import io.swagger.annotations.ApiModelProperty;
import org.ys.utils.dto.RequestDTO;

import javax.validation.constraints.NotNull;

public class ArticleA06InputDTO extends RequestDTO {
    @NotNull(message = "用户id不能为空")
    private Integer userId;


    @ApiModelProperty(value = "用户id", name = "userId", dataType = "Integer")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
