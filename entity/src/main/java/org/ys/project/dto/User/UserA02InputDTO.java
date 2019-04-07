package org.ys.project.dto.User;

import io.swagger.annotations.ApiModelProperty;
import org.ys.utils.dto.RequestDTO;

import javax.validation.constraints.NotNull;

public class UserA02InputDTO extends RequestDTO {

//    @NotNull(message = "用户名不能为空")
    private String userName;

    @NotNull(message = "用户昵称不能为空")
    private String nickName;

    @NotNull(message = "密码不能为空")
    private String password;

    private String phone;

    private String autograph;

    private String email;

    @ApiModelProperty(value = "用户名", name = "userName", dataType = "String")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @ApiModelProperty(value = "昵称", name = "nickName", dataType = "String")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @ApiModelProperty(value = "密码", name = "password", dataType = "String")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ApiModelProperty(value = "电话号码", name = "phone", dataType = "String")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @ApiModelProperty(value = "签名", name = "autograph", dataType = "String")
    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    @ApiModelProperty(value = "邮箱", name = "email", dataType = "String")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
