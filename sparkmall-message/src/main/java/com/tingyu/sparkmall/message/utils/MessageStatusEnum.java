package com.tingyu.sparkmall.message.utils;

/**
 *
 * 消息状态枚举
 * @Author essionshy
 * @Create 2020/12/14 10:14
 * @Version sparkmall
 */
public enum MessageStatusEnum {

    DELIVER_ERROR(0,"发送失败"),//与 MQ 连接异常
    DELIVER_SUCCESS(1,"发送成功"),
    ACK_SUCCESS(2,"签收成功"),
    ACK_ERROR(3,"签收失败"),
    TO_SERVER_ERROR(4,"消息抵达服务器失败"),
    TO_QUEUE_ERROR(5,"消息抵达队列失败");
    private int code;

    private String name;

    MessageStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }


    public static String getMessageStatusName(int code) {

        if (code == MessageStatusEnum.DELIVER_ERROR.getCode()) {
            return MessageStatusEnum.DELIVER_ERROR.getName();
        }
        if (code == MessageStatusEnum.DELIVER_SUCCESS.getCode()) {
            return MessageStatusEnum.DELIVER_SUCCESS.getName();
        }
        if (code == MessageStatusEnum.ACK_ERROR.getCode()) {
            return MessageStatusEnum.ACK_ERROR.getName();
        }
        if (code == MessageStatusEnum.ACK_SUCCESS.getCode()) {
            return MessageStatusEnum.ACK_SUCCESS.getName();
        }

        if (code == MessageStatusEnum.TO_SERVER_ERROR.getCode()) {
            return MessageStatusEnum.TO_SERVER_ERROR.getName();
        }
        if (code == MessageStatusEnum.TO_QUEUE_ERROR.getCode()) {
            return MessageStatusEnum.TO_QUEUE_ERROR.getName();
        }

        return null;
    }

}
