package com.lida.cloud.exception;


import com.lida.cloud.common.ReCode;

/**
 * Service层公用的Exception.
 * 
 * 继承自RuntimeException, 从由Spring管理事务的函数中抛出时会触发事务回滚.
 * 
 * @author 杜利达
 * @version 0.1
 * @since 0.1
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 3583566093089790852L;
    
    private Integer code;
    
    
    public ServiceException(String message) {
        super(message);
        this.code = ReCode.ERROR;
    }
    public ServiceException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
