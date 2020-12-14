package com.tingyu.sparkmall.seckill.controller;

import com.tingyu.sparkmall.commons.support.CommonResult;
import com.tingyu.sparkmall.commons.utils.R;
import com.tingyu.sparkmall.seckill.service.SeckillService;
import com.tingyu.sparkmall.seckill.vo.SeckillSkuRedisVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author essionshy
 * @Create 2020/12/11 14:53
 * @Version renren-fast
 */

@RestController
@RequestMapping("/seckill")
public class SeckillController {

    @Resource
    private SeckillService seckillService;

    @ApiOperation("秒杀服务上架")
    @GetMapping("/up")
    public CommonResult up() {
        seckillService.up();
        return CommonResult.success();
    }


    @ApiOperation("查询所有秒杀活动列表")
    @GetMapping("list/current/session/skus")
    public R listCurrentSeckillSessionSkus() {
        List<SeckillSkuRedisVo> data = seckillService.listCurrentSeckillSessionSkus();

        return R.ok().put("items", data);
    }

    /**
     * 开始秒杀商品
     * @return
     */
    @GetMapping("/run/{killId}/{accessToken}/{num}")
    public R seckill(@PathVariable("killId") String killId,
                     @PathVariable("accessToken") String accessToken,
                     @PathVariable("num") Integer num) throws Exception {
       String orderNo= seckillService.seckill(killId,accessToken,num);
        return R.ok().put("orderNo",orderNo);
    }


}
