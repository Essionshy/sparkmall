package com.tingyu.sparkmall.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Author essionshy
 * @Create 2020/5/8 21:20
 * @Version sparkmall
 */
public class RecordEvent extends ApplicationEvent {
    public RecordEvent(Object source) {
        super(source);
    }
}
