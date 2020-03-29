package com.lida.cloud.auth.controller;

import com.lida.cloud.auth.service.LoginService;
import com.lida.cloud.auth.util.AuthToken;
import com.lida.cloud.common.ReMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: 杜利达
 * @date: 2020/3/29 20:55
 */
@Controller
@RequestMapping("/oauth")
public class AuthController {

    @Value("${auth.clientId}")
    private String clientId;

    @Value("${auth.clientSecret}")
    private String clientSecret;

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    public ReMsg login(String username, String password){
        //校验参数
        if (StringUtils.isEmpty(username)){
            throw new RuntimeException("请输入用户名");
        }
        if (StringUtils.isEmpty(password)){
            throw new RuntimeException("请输入密码");
        }
        //申请令牌 authtoken
        AuthToken authToken = loginService.login(username, password, clientId, clientSecret);

        //返回结果
        return ReMsg.ok(authToken.getJti());
    }

}
