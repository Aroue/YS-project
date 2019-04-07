package org.ys.project.entity;

import java.util.Date;

public class User {
    private Integer id;

    private String userName;

    private String nickName;

    private String password;

    private String phone;

    private String autograph;

    private String email;

    private Date createdAt;

    private Date updatedAt;

    public User() {
    }

    public User(Integer id, String userName, String nickName, String password, String phone, String autograph, String email, Date createdAt, Date updatedAt) {
        this.id = id;
        this.userName = userName;
        this.nickName = nickName;
        this.password = password;
        this.phone = phone;
        this.autograph = autograph;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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