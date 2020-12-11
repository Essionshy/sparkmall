package com.tingyu.sparkmall.commons.support;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author essionshy
 * @Create 2020/4/22 18:27
 * @Version sparkmall
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Accessors(chain = true)
public class CommonResult<T> {

    private int code;

    private String msg;


    private T data;


    public CommonResult(int code, String msg) {
        this(code, msg, null);
    }



    /**
     * 默认成功消息
     * @return
     */
    public static CommonResult success(){
        return new CommonResult(0,"success");
    }

    /**
     * 默认错误消息
     * @return
     */
    public static CommonResult error(){
        return new CommonResult(5000,"error");
    }


    /**
     * 自定义成功消息
     * @return
     */
    public static CommonResult success(int code,String msg){
        return new CommonResult(code,msg);
    }

    /**
     * 自定义错误消息
     * @return
     */
    public static CommonResult error(int code,String msg){
        return new CommonResult(code,msg);
    }



}
