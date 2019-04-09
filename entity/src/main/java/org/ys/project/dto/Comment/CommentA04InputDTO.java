package org.ys.project.dto.Comment;

import io.swagger.annotations.ApiModelProperty;
import org.ys.utils.dto.RequestDTO;

import javax.validation.constraints.NotNull;

public class CommentA04InputDTO extends RequestDTO {

    @NotNull(message = "ID不能为空")
    private Integer id;

    @ApiModelProperty(value = "ID", name = "id", dataType = "Integer")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
