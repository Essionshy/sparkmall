package com.tingyu.sparkmall.listener;

import com.tingyu.sparkmall.event.RecordEvent;
import com.tingyu.sparkmall.param.LotteryParam;
import com.tingyu.sparkmall.service.LotteryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author essionshy
 * @Create 2020/5/8 22:08
 * @Version sparkmall
 */
@Slf4j
@Service
public class LotteryRecordListener implements ApplicationListener<RecordEvent> {

    @Resource
    LotteryService lotteryService;

    @Async
    @Override
    public void onApplicationEvent(RecordEvent recordEvent) {
        LotteryParam param = (LotteryParam) recordEvent.getSource();
        lotteryService.sendRecordMessage(param);
    }
}
