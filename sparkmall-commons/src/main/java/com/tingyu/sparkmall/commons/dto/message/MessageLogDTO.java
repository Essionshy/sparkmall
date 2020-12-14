package com.tingyu.sparkmall.commons.dto.message;

import lombok.Data;

import java.util.Date;

/**
 * @Author essionshy
 * @Create 2020/12/14 17:15
 * @Version sparkmall
 */
@Data
public class MessageLogDTO {
    private Long id;
    /**
     * 消息ID
     */
    private String msgId;
    /**
     * 交换机名称
     */
    private String exchangeName;
    /**
     * 路由键
     */
    private String routingKey;
    /**
     * 目的地名称
     */
    private String destination;
    /**
     * 目的地类型
     */
    private Integer destinationType;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 消息状态
     */
    private String status;
    /**
     * 创建时间
     */
    private Date createTime;
}
