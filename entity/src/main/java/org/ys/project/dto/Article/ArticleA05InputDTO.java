package org.ys.project.dto.Article;

import io.swagger.annotations.ApiModelProperty;
import org.ys.utils.dto.RequestDTO;

import javax.validation.constraints.NotNull;

public class ArticleA05InputDTO extends RequestDTO {
    @NotNull(message = "文章类型id不能为空")
    private Integer typeId;


    @ApiModelProperty(value = "文章id", name = "typeId", dataType = "Integer")
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
