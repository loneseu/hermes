package cn.edu.seu.lone.common.utils.exception;

import cn.edu.seu.lone.common.utils.exception.enums.ErrorCodeEnum;

/**
 * 自定义业务异常
 */
public class BusinessException extends AbstractException{
    /**
     *
     */
    private static final long serialVersionUID = -1L;

    /**
     * 错误码
     */
    private final ErrorCodeEnum errorCodeEnum;


    public BusinessException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getCode() + ":" + errorCodeEnum.getMessage());
        this.errorCodeEnum = errorCodeEnum;
    }

    public ErrorCodeEnum getErrorCodeEnum() {
        return errorCodeEnum;
    }
}
