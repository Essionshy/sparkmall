package com.tingyu.sparkmall.lottery.service.fallback;

import com.tingyu.sparkmall.commons.dto.MemberDTO;
import com.tingyu.sparkmall.lottery.feign.MemberFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 处理会员服务调用失败降级处理
 *
 * @Author essionshy
 * @Create 2020/12/1 10:23
 * @Version renren-fast
 */
@Service
@Slf4j
public class MemberFeignFallbackServiceImpl implements MemberFeignService {


    @Override
    public MemberDTO getByMemberNo(String memberNo) {
        log.info("lottery fallback handler");
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setSuccess(false);
        return memberDTO;
    }
}
