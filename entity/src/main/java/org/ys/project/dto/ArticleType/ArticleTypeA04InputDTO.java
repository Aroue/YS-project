package org.ys.project.dto.ArticleType;

import io.swagger.annotations.ApiModelProperty;
import org.ys.utils.dto.RequestDTO;

import javax.validation.constraints.NotNull;

public class ArticleTypeA04InputDTO extends RequestDTO {

    @NotNull(message = "文章类型id不能为空")
    private Integer id;

    @ApiModelProperty(value = "文章类型id", name = "id", dataType = "Integer")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
