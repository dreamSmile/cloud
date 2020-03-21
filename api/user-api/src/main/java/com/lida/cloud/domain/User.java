package com.lida.cloud.domain;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author: 杜利达
 * @date: 2020/3/21 23:38
 */
@Data
public class User {
    private Long userId;

    private String userName;

    private String userPassword;

    private String userMobile;

    /**
     * 积分
     */
    private Integer userScore;

    /**
     * 注册时间
     */
    private LocalDateTime userRegTime;
}