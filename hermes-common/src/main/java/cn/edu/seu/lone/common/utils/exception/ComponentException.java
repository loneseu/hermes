package cn.edu.seu.lone.common.utils.exception;

import cn.edu.seu.lone.common.utils.exception.enums.ErrorCodeEnum;

/**
 * 自定义组件异常
 */
public class ComponentException extends AbstractException{

    /**
     *
     */
    private static final long serialVersionUID = 2333790764399190094L;

    /**
     * 错误码枚举信息
     */
    private ErrorCodeEnum errorCodeEnum;

    /**
     * 扩展的错误信息
     */
    private String extendErrorMessage;


    public ComponentException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getCode() + ":" + errorCodeEnum.getMessage());
        this.errorCodeEnum = errorCodeEnum;
    }


    public ComponentException(ErrorCodeEnum errorCodeEnum, String extendErrorMessage) {
        super(errorCodeEnum.getCode() + ":" + errorCodeEnum.getMessage() + "["
                + extendErrorMessage + "]");
        this.errorCodeEnum = errorCodeEnum;
        this.extendErrorMessage = extendErrorMessage;
    }


    public ErrorCodeEnum getErrorCodeEnum() {
        return errorCodeEnum;
    }

    public void setErrorCodeEnum(ErrorCodeEnum errorCodeEnum) {
        this.errorCodeEnum = errorCodeEnum;
    }

    public String getExtendErrorMessage() {
        return extendErrorMessage;
    }

    public void setExtendErrorMessage(String extendErrorMessage) {
        this.extendErrorMessage = extendErrorMessage;
    }

}
