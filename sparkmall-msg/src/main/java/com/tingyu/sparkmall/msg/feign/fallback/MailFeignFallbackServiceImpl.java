package com.tingyu.sparkmall.msg.feign.fallback;

import com.tingyu.sparkmall.commons.support.MailMessage;
import com.tingyu.sparkmall.msg.feign.MailFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author essionshy
 * @Create 2020/12/3 21:01
 * @Version renren-fast
 */
@Service
@Slf4j
public class MailFeignFallbackServiceImpl implements MailFeignService {


    @Override
    public void send(MailMessage message) {
        log.info("调用邮件服务失败，请稍后再试...");
    }
}
