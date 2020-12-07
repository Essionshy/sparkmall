package com.tingyu.sparkmall.pay.feign;

import com.tingyu.sparkmall.commons.support.MailMessage;
import com.tingyu.sparkmall.pay.feign.fallback.MessageFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author essionshy
 * @Create 2020/12/3 17:35
 * @Version renren-fast
 */
@FeignClient(value = "sparkmall-msg", fallback = MessageFallbackServiceImpl.class)
@Component
public interface MessageFeignService {
    @PostMapping("/msg/send")
    boolean send(@RequestBody MailMessage message);
}
