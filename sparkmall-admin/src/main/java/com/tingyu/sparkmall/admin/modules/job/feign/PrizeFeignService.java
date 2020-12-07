package com.tingyu.sparkmall.admin.modules.job.feign;

import com.tingyu.sparkmall.commons.dto.PrizeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author essionshy
 * @Create 2020/6/5 12:05
 * @Version renren-fast
 */
@FeignClient("sparkmall-lottery")
public interface PrizeFeignService {

    @RequestMapping("lottery/prize/find/all")
    List<PrizeDTO> findAllUnStartedPrize();

    @RequestMapping("lottery/prize/update")
    boolean update(PrizeDTO prize);
}
