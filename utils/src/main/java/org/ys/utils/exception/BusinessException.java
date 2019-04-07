package org.ys.utils.exception;

import org.ys.utils.Message;

public class BusinessException extends RuntimeException {

    /**
     * errorCode
     */
    private String errorCode;

    public BusinessException() {
        super();
    }

    /**
     * 传Message类型
     *
     * @param message
     */
    public BusinessException(Message message) {
        super(message.toString());
        this.errorCode = message.getCode();
    }

    /**
     * 直接传错误消息
     *
     * @param message
     */
    public BusinessException(String message) {
        super(message);
    }

    /**
     * 获取errorCode
     *
     * @return
     */
    public String getErrorCode() {
        return this.errorCode;
    }
}
