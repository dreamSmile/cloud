package com.lida.cloud.service.impl;

import com.lida.cloud.domain.User;
import com.lida.cloud.domain.UserRegister;
import com.lida.cloud.exception.ServiceException;
import com.lida.cloud.mapper.UserMapper;
import com.lida.cloud.service.IUserService;
import com.lida.cloud.utils.IDWorker;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Override
    public User register(UserRegister userRegister) {
        //暂时先使用明文，不集成安全框架
        User user = new User();
        BeanUtils.copyProperties(userRegister, user);
        user.setUserMoney(BigDecimal.TEN);
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
        user.setUserMoney(BigDecimal.ZERO);
        int resultNum = userMapper.updateByPrimaryKey(user);
        if (resultNum != 1) {
            throw new ServiceException("扣余额失败");
        }
    }
}
