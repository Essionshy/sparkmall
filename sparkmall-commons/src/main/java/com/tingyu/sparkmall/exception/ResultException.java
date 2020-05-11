package com.tingyu.sparkmall.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author essionshy
 * @Create 2020/4/12 22:14
 * @Version crm
 */

@NoArgsConstructor
@Data
@ToString
@Accessors(chain = true)
public class ResultException extends RuntimeException {
    /**
     * 异常代码
     */
    private int code = 500;
    /**
     * 异常消息
     */
    private String message;

    public ResultException(String message) {

        super(message);
        this.message = message;
    }

    public ResultException(int code, String message) {
        super(message);
        this.message = message;
        this.code = code;
    }
}
