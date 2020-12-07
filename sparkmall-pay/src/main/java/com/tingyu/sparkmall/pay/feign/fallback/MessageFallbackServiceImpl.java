package com.tingyu.sparkmall.pay.feign.fallback;

import com.tingyu.sparkmall.commons.support.MailMessage;
import com.tingyu.sparkmall.pay.feign.MessageFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author essionshy
 * @Create 2020/12/3 17:39
 * @Version renren-fast
 */
@Service
@Slf4j
public class MessageFallbackServiceImpl implements MessageFeignService {
    @Override
    public boolean send(MailMessage message) {
        log.info("调用消息服务失败，请稍后再试...");
        return false;
    }
}
