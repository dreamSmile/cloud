package com.lida.cloud.controller;

import com.lida.cloud.common.ReMsg;
import com.lida.cloud.domain.UserDto;
import com.lida.cloud.domain.UserRegister;
import com.lida.cloud.service.IUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 杜利达
 * @date: 2020/3/15 14:07
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Reference(version = "0.0.1")
    private IUserService userService;

    @PostMapping(value = "/register")
    public ReMsg<UserDto> register(@Validated @RequestBody UserRegister userRegister) {
        return ReMsg.ok(userService.register(userRegister));
    }
}
