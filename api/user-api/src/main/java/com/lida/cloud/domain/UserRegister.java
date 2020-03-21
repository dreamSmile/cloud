package com.lida.cloud.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author: 杜利达
 * @date: 2020/3/15 13:25
 */
@Data
public class UserRegister implements Serializable {

    @NotBlank(message = "用户名不得为空")
    private String userName;
    @NotBlank(message = "密码不得为空")
    private String userPassword;
    @NotBlank(message = "手机号不得为空")
    private String userMobile;


}
