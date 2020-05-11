package com.tingyu.sparkmall.support;

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

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Accessors(chain = true)
public class CommonResult<T> {

    private Integer code;

    private String msg;

    private long count;

    private T data;

    public CommonResult(Long count, T data) {
        this(null, "", count, data);
    }

    public CommonResult(Integer code, String msg) {
        this(code, msg, 0, null);
    }

    public CommonResult(Integer code, String msg, T data) {
        this(code, msg, 0, data);
    }


}
