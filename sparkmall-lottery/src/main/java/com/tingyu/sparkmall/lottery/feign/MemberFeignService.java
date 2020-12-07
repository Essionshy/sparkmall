package com.tingyu.sparkmall.lottery.feign;

import com.tingyu.sparkmall.commons.dto.MemberDTO;
import com.tingyu.sparkmall.lottery.service.fallback.MemberFeignFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author essionshy
 * @Create 2020/5/8 23:44
 * @Version sparkmall
 */
@FeignClient(value = "sparkmall-member", fallback = MemberFeignFallbackServiceImpl.class)
@Component
public interface MemberFeignService {

    @GetMapping("/member/feign/info/{memberNo}")
    MemberDTO getByMemberNo(@PathVariable("memberNo") String memberNo);
}
