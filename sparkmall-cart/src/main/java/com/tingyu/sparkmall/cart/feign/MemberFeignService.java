package com.tingyu.sparkmall.cart.feign;

import com.tingyu.sparkmall.commons.dto.MemberDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author essionshy
 * @Create 2020/12/2 12:03
 * @Version renren-fast
 */
@FeignClient(value = "sparkmall-member")
@Component
public interface MemberFeignService {

    @GetMapping("/member/feign/info/{memberNo}")
    MemberDTO getByMemberNo(@PathVariable("memberNo") String memberNo);

}
