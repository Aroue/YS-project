package org.ys.project.dto.Article;

import io.swagger.annotations.ApiModelProperty;
import org.ys.utils.dto.RequestDTO;

import javax.validation.constraints.NotNull;

public class ArticleA02InputDTO extends RequestDTO {

    @NotNull(message = "用户ID不能为空")
    private Integer userId;

    private Integer typeId;

    @NotNull(message = "文章标题不能为空")
    private String title;

    @NotNull(message = "文章内容不能为空")
    private String content;

    @ApiModelProperty(value = "用户ID", name = "userId", dataType = "Integer")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @ApiModelProperty(value = "文章类型ID", name = "typeId", dataType = "Integer")
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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
