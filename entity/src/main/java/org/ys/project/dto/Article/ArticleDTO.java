package org.ys.project.dto.Article;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.ys.project.dto.Comment.CommentBaseDTO;
import org.ys.utils.dto.ResponseDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleDTO extends ResponseDTO {

    private Integer id;

    private Integer userId;

    private Integer typeId;

    private String title;

    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    private List<CommentBaseDTO> comments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<CommentBaseDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentBaseDTO> comments) {
        this.comments = comments;
    }
}
