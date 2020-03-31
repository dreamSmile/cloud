package com.lida.cloud.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author: 杜利达
 * @date: 2020/3/31 22:14
 */
@Data
public class LoginForm implements Serializable {
    @NotBlank
    private String mobile;
    @NotBlank
    private String password;
    /**
     * 登陆来源
     */
    @NotBlank
    private Integer loginFrom;
}
