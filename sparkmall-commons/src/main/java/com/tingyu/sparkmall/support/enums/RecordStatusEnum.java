package com.tingyu.sparkmall.support.enums;

/**
 * @Author essionshy
 * @Create 2020/5/9 14:41
 * @Version sparkmall
 */
public enum RecordStatusEnum {

    CREATE(0, "已创建"),
    POSTING(1, "邮寄中"),
    RECIVE(2, "已签收");

    private int code;

    private String value;

    RecordStatusEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
