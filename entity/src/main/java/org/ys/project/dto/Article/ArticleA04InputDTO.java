package org.ys.project.dto.Article;

import io.swagger.annotations.ApiModelProperty;
import org.ys.utils.dto.RequestDTO;

import javax.validation.constraints.NotNull;

public class ArticleA04InputDTO extends RequestDTO {
    @NotNull(message = "文章id不能为空")
    private Integer id;


    @ApiModelProperty(value = "文章id", name = "id", dataType = "Integer")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
