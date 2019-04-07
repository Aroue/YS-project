package org.ys.project.dto.ArticleType;

import io.swagger.annotations.ApiModelProperty;
import org.ys.utils.dto.RequestDTO;

import javax.validation.constraints.NotNull;

public class ArticleTypeA03InputDTO extends RequestDTO {

    @NotNull(message = "文章类型id不能为空")
    private Integer id;

    @NotNull(message = "文章类型名称不能为空")
    private String title;


    @ApiModelProperty(value = "文章类型id", name = "id", dataType = "Integer")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ApiModelProperty(value = "文章类型名", name = "title", dataType = "String")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
