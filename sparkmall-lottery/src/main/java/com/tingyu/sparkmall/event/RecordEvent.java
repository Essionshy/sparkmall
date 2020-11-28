package com.tingyu.sparkmall.event;

import org.springframework.context.ApplicationEvent;

/**
 * 中奖记录事件
 * @Author essionshy
 * @Create 2020/5/8 21:20
 * @Version sparkmall
 */

public class RecordEvent extends ApplicationEvent {
    public RecordEvent(Object source) {
        super(source);
    }
}
