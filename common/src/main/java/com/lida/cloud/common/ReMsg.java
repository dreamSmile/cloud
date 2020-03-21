package com.lida.cloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author: 杜利达
 * @date: 2020/3/8 19:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReMsg<T> {
    private Integer code;
    private String message;
    private T data;

    public ReMsg(Integer code, String message) {
        this(code, message, null);
    }

    public static ReMsg ok(Object data) {
        return new ReMsg(ReCode.OK, "success", data);
    }
    public static ReMsg error(Integer code, String msg) {
        return new ReMsg(code, msg);
    }
    public static boolean isOk(ReMsg reMsg) {
        if (Objects.isNull(reMsg)) {
            return false;
        }
        if (ReCode.OK.equals(reMsg.getCode())) {
            return true;
        }
        return false;
    }
}
