package org.ys.project.dto.Comment;

import io.swagger.annotations.ApiModelProperty;
import org.ys.utils.dto.RequestDTO;

import javax.validation.constraints.NotNull;

public class CommentA02InputDTO  extends RequestDTO {

    @NotNull(message = "文章ID不能为空")
    private Integer articleId;

    @ApiModelProperty(value = "文章ID", name = "articleId", dataType = "Integer")
    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}
