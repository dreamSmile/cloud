package com.lida.cloud.service;

import com.lida.cloud.domain.User;
import com.lida.cloud.domain.UserRegister;

/**
 * @author: 杜利达
 * @date: 2020/3/13 14:26
 */
public interface IUserService {

    /**
     * 注册
     * @param userRegister
     * @return
     */
    User register(UserRegister userRegister);

    /**
     * 通过id查找用户
     * @param userId
     * @return
     */
    User findById(Long userId);

    /**
     * 只为测试，直接至0
     * @param userId
     * @return
     */
    void userUserMoney(Long userId);
}
