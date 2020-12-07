package com.tingyu.sparkmall.commons.support.enums;

/**
 * @Author essionshy
 * @Create 2020/5/8 20:45
 * @Version sparkmall
 */
public enum LotteryStatusEnum {

    UNSTART(0, "未开始"),
    RUNNING(1, "进行中"),
    OVER(2, "已结束");

    private int code;

    private String value;

    LotteryStatusEnum(int code, String value) {
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
