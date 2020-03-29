package com.lida.cloud.auth.service;

import com.lida.cloud.auth.util.AuthToken;

/**
 * @author: 杜利达
 * @date: 2020/3/29 21:15
 */
public interface LoginService {

    /**
     * 登录
     * @param username
     * @param password
     * @param clientId
     * @param clientSecret
     * @return
     */
    AuthToken login(String username, String password, String clientId, String clientSecret);
}
