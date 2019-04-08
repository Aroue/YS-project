package org.ys.project.entity;

import java.util.Date;

public class Comment {

    private Integer id;

    private Integer articleId;

    private Integer parentId;

    private Integer userId;

    private String content;

    private Date createdAt;

    private Date updatedAt;

    public Comment() {
    }

    public Comment(Integer id, Integer articleId, Integer parentId, Integer userId, String content, Date createdAt, Date updatedAt) {
        this.id = id;
        this.articleId = articleId;
        this.parentId = parentId;
        this.userId = userId;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
