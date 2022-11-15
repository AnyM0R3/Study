package com.lihua.internalcommon.dto;


import com.lihua.internalcommon.constant.CommonStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResponseResult<T> {

    private int code;
    private String message;
    private T data;

    /**
     * 成功的响应方法
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseResult success(T data){
        return new ResponseResult().setCode(CommonStatusEnum.SUCCESS.getCode()).setMessage(CommonStatusEnum.SUCCESS.getMessage()).setData(data);
    }

    /**
     * 成功响应方法
     * @param <T>
     * @return
     */
    public static <T> ResponseResult success(){
        return new ResponseResult().setCode(CommonStatusEnum.SUCCESS.getCode()).setMessage(CommonStatusEnum.SUCCESS.getMessage());
    }

    /**
     * 统一的失败
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseResult fail(T data){
        return new ResponseResult().setData(data);
    }

    /**
     * 自定义失败方法：错误码， 错误信息
     * @param code
     * @param message
     * @return
     */
    public static ResponseResult fail(int code, String message){
        return new ResponseResult().setCode(code).setMessage(message);
    }

    /**
     * 自定义失败方法：错误码， 错误信息, 数据
     * @param code
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseResult fail(int code, String message, T data){
        return new ResponseResult().setCode(code).setMessage(message).setData(data);
    }
}
