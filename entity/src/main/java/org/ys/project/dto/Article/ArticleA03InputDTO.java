package org.ys.project.dto.Article;

import io.swagger.annotations.ApiModelProperty;
import org.ys.utils.dto.RequestDTO;

import javax.validation.constraints.NotNull;

public class ArticleA03InputDTO extends RequestDTO {

    @NotNull(message = "文章id不能为空")
    private Integer id;

    @NotNull(message = "文章标题不能为空")
    private String title;

    @NotNull(message = "文章内容不能为空")
    private String content;

    @ApiModelProperty(value = "文章id", name = "id", dataType = "Integer")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ApiModelProperty(value = "文章名", name = "title", dataType = "String")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ApiModelProperty(value = "文章内容", name = "content", dataType = "String")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
