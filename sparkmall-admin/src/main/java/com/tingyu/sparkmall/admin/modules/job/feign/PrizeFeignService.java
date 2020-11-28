package com.tingyu.sparkmall.admin.modules.job.feign;

import com.tingyu.sparkmall.entity.lottery.PrizeEntity;
import com.tingyu.sparkmall.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author essionshy
 * @Create 2020/6/5 12:05
 * @Version renren-fast
 */
@FeignClient("sparkmall-lottery")
public interface PrizeFeignService {

    @RequestMapping("lottery/prize/find/all")
    public R findAllUnStartedPrize();

    @RequestMapping("lottery/prize/update")
    public R update( PrizeEntity prize);
}
