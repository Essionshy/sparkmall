package com.tingyu.sparkmall.auth.feign;

import com.tingyu.sparkmall.commons.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author essionshy
 * @Create 2020/12/8 12:40
 * @Version renren-fast
 */
@FeignClient("sparkmall-third-party")
public interface ThirdPartyFeignService {

    @GetMapping("/sms/send/code/{phone}/{code}")
    R sendVerifyCode(@PathVariable("phone") String phone, @PathVariable("code") String code);

}
