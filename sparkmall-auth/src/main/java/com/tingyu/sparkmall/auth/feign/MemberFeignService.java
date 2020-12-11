package com.tingyu.sparkmall.auth.feign;

import com.tingyu.sparkmall.auth.param.MemberLoginParam;
import com.tingyu.sparkmall.auth.param.MemberRegisterParam;
import com.tingyu.sparkmall.commons.dto.MemberDTO;
import com.tingyu.sparkmall.commons.support.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author essionshy
 * @Create 2020/12/8 14:44
 * @Version renren-fast
 */
@FeignClient("sparkmall-member")
@Component
public interface MemberFeignService {

    @PostMapping("/member/register")
    CommonResult register(@RequestBody MemberRegisterParam param);

    @PostMapping("/member/login")
    CommonResult<MemberDTO> login(@RequestBody MemberLoginParam param);

}
