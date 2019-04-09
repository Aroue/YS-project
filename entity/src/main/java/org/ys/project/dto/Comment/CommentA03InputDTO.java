package org.ys.project.dto.Comment;

import io.swagger.annotations.ApiModelProperty;
import org.ys.utils.dto.RequestDTO;

import javax.validation.constraints.NotNull;

public class CommentA03InputDTO extends RequestDTO {

    @NotNull(message = "文章ID不能为空")
    private Integer articleId;

    private Integer parentId;

    @NotNull(message = "用户ID不能为空")
    private Integer userId;

    @NotNull(message = "内容不能为空")
    private String content;

    @ApiModelProperty(value = "文章ID", name = "articleId", dataType = "Integer")
    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    @ApiModelProperty(value = "上级评论ID", name = "parentId", dataType = "Integer")
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @ApiModelProperty(value = "用户ID", name = "userId", dataType = "Integer")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @ApiModelProperty(value = "内容", name = "content", dataType = "Integer")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
