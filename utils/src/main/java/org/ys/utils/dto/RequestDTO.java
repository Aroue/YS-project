package org.ys.utils.dto;

import io.swagger.annotations.ApiModelProperty;


public class RequestDTO extends BaseDTO {
    @ApiModelProperty(value = "Swagger测试用token", name = "token", dataType = "String")
    private String token;

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
