package com.tingyu.sparkmall.feign;

import com.tingyu.sparkmall.dto.MemberDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author essionshy
 * @Create 2020/5/8 23:44
 * @Version sparkmall
 */
@FeignClient("sparkmall-member")
public interface MemberFeignService {

    @GetMapping("/member/feign/info/{userId}")
    MemberDTO getMemberInfo(@PathVariable("userId") Long userId);
}
