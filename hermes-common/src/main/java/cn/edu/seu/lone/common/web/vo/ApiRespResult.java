package cn.edu.seu.lone.common.web.vo;

import cn.edu.seu.lone.common.utils.exception.enums.ApplicationErrorCodeEnum;
import cn.edu.seu.lone.common.utils.exception.enums.ErrorCodeEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

@Data
public class ApiRespResult<T> implements Serializable {

    /**
     * 结果码
     */
    private String code = ApplicationErrorCodeEnum.SUCCESS.getCode();

    /**
     * 结果信息
     */
    private String msg = ApplicationErrorCodeEnum.SUCCESS.getMessage();

    /**
     * 扩展对象(放置分页信息、其他信息等)
     */
    private Object extendData;

    /**
     * 返回结果的数据对象
     */
    private T data;

    public ApiRespResult() {
    }

    //  *** 构造方法 ***
    public ApiRespResult(String code) {
        this.code = code;
    }

    public ApiRespResult(String code, String message){
        this.code = code;
        this.msg = message;
    }

    public ApiRespResult(ErrorCodeEnum errorCodeEnum){
        this.code = errorCodeEnum.getCode();
        this.msg = errorCodeEnum.getMessage();
    }

    //  *** 错误信息封装方法 *＊＊
    public static <T> ApiRespResult<T> error(ErrorCodeEnum errorCodeEnum){
        return new ApiRespResult<T>(errorCodeEnum);
    }
    public static <T> ApiRespResult<T> systemError(String exceptionMsg){
        ApiRespResult<T> error =  new ApiRespResult<>(ApplicationErrorCodeEnum.FAILURE);
        error.setMsg(error.getMsg() + ":" + exceptionMsg);
        return error;
    }

    public static <T> ApiRespResult<T> error(String code, String msg){
        return new ApiRespResult<T>(code,msg);
    }

    public static <T> ApiRespResult<T> error(String code, String msg,T data){
        return new ApiRespResult<T>(code,msg).setData(data);
    }

    /**
     * 用于参数校验提示信息
     * @param exceptionMsg
     * @param <T>
     * @return
     */
    public static <T> ApiRespResult<T> validError(String exceptionMsg) {
        ApiRespResult<T> error = new ApiRespResult<T>(ApplicationErrorCodeEnum.PARAMS_NOT_VALID);
        error.setMsg(error.getMsg() + ":" + exceptionMsg);
        return error;
    }

    //  *** 错误信息封装方法 end *＊＊


    //  *** 成功信息封装方法 *＊＊
    public static  ApiRespResult<Void> success(){
        return success(null);
    }

    public static <T> ApiRespResult<T> success(T data){
        return success(data, null);
    }

    public static <T> ApiRespResult<T> success(T data, Object extendData ){
        return new ApiRespResult<T>().setData(data).setExtendData(extendData);
    }

    public Boolean isSuccess(){
        return ApplicationErrorCodeEnum.SUCCESS.getCode().equals(getCode());
    }
    //  *** 成功信息封装方法 end *＊＊


    public ApiRespResult<T> setData(T data) {
        this.data = data;
        return this;
    }

    public ApiRespResult<T> setExtendData(Object extendData) {
        this.extendData = extendData;
        return this;
    }


    @Override
    public String toString() {
        return "[code=" + code + ", msg=" + msg + ", extendData=" + extendData + ", data=" + data + "]";
    }
}
