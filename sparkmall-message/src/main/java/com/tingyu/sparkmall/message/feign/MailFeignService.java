package com.tingyu.sparkmall.message.feign;

import com.tingyu.sparkmall.commons.support.MailMessage;
import com.tingyu.sparkmall.message.feign.fallback.MailFeignFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author essionshy
 * @Create 2020/12/3 20:55
 * @Version renren-fast
 */
@FeignClient(value = "sparkmall-mail", fallback = MailFeignFallbackServiceImpl.class)
@Component
public interface MailFeignService {

    @PostMapping("/mail/send")
    void send(@RequestBody MailMessage message);
}
