package org.ys.project.dto.User;

import io.swagger.annotations.ApiModelProperty;
import org.ys.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;

public class UserA06InputDTO extends RequestDTO {

    @NotNull(message = "用户名不能为空")
    private String userName;

    @NotNull(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "用户名", name = "userName", dataType = "String")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @ApiModelProperty(value = "密码", name = "password", dataType = "String")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
