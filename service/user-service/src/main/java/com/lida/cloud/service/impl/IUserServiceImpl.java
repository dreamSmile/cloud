package com.lida.cloud.service.impl;

import com.lida.cloud.domain.LoginForm;
import com.lida.cloud.domain.User;
import com.lida.cloud.domain.UserRegister;
import com.lida.cloud.exception.ServiceException;
import com.lida.cloud.mapper.UserMapper;
import com.lida.cloud.service.IUserService;
import com.lida.cloud.utils.IDWorker;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author: 杜利达
 * @date: 2020/3/15 13:28
 */
@Service(version = "0.0.1")
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IDWorker idWorker;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User register(UserRegister userRegister) {
        User user = new User();
        BeanUtils.copyProperties(userRegister, user);

        user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));

        user.setUserScore(0);
        user.setUserRegTime(LocalDateTime.now());
        user.setUserId(idWorker.nextId());
        int num = userMapper.insert(user);
        if (num == 1) {
            return user;
        } else {
            throw new ServiceException("注册用户失败");
        }
    }

    @Override
    public User findById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void userUserMoney(Long userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            throw new ServiceException("用户不存在");
        }
        int resultNum = userMapper.updateByPrimaryKey(user);
        if (resultNum != 1) {
            throw new ServiceException("扣余额失败");
        }
    }

    @Override
    public void login(LoginForm loginForm) {
        User user = userMapper.selectByMobile(loginForm.getMobile());
        if (user == null) {
            throw new ServiceException("用户不存在，登录失败");
        }
        if(!bCryptPasswordEncoder.matches(loginForm.getPassword(),user.getUserPassword())){
            throw new ServiceException("密码不正确");
        }
    }
}
