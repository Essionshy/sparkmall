package com.tingyu.sparkmall.msg.feign;

import com.tingyu.sparkmall.commons.support.MailMessage;
import com.tingyu.sparkmall.msg.feign.fallback.MailFeignFallbackServiceImpl;
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
