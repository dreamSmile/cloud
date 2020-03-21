package com.lida.cloud.mapper;

import com.lida.cloud.domain.User;

/**
 * @author: 杜利达
 * @date: 2020/3/21 23:38
 */
public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}