package com.tingyu.sparkmall.controller;

import com.tingyu.sparkmall.annotation.SysLog;
import com.tingyu.sparkmall.exception.ResultException;
import com.tingyu.sparkmall.param.LotteryParam;
import com.tingyu.sparkmall.service.LotteryService;
import com.tingyu.sparkmall.service.PrizeService;
import com.tingyu.sparkmall.support.CommonResult;
import com.tingyu.sparkmall.support.LotteryStatusEnum;
import com.tingyu.sparkmall.support.enums.BizCodeEnum;
import com.tingyu.sparkmall.validator.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author essionshy
 * @Create 2020/5/8 12:24
 * @Version sparkmall
 */
@RestController
public class LotteryController {

    @Resource
    LotteryService lotteryService;

    @Resource
    PrizeService prizeService;


    @SysLog
    @PostMapping("lottery")
    public CommonResult lottery(@RequestBody LotteryParam param) {
        Assert.isNull(param, BizCodeEnum.NULL_POINTER_EXCEPTION.getMessage());

        //验证当前用户是否已经中奖
        if (lotteryService.isExists(param)) {
            throw new ResultException(BizCodeEnum.LOTTERY_EXISTS.getCode(), BizCodeEnum.LOTTERY_EXISTS.getMessage());
        }
        //验证奖品是否已经抽取完成
        if (lotteryService.isOver(param.getPrizeId())) {
            //当奖品抽取完成时，修改抽奖状态
            prizeService.updateStatus(LotteryStatusEnum.OVER.getCode(), param.getPrizeId());
            throw new ResultException(BizCodeEnum.LOTTERY_OVER.getCode(), BizCodeEnum.LOTTERY_OVER.getMessage());
        }
        //验证当前请求是否合法
        Integer prizeId = lotteryService.lottery(param);
        return new CommonResult(BizCodeEnum.LOTTERY_SUCCESS.getCode(), BizCodeEnum.LOTTERY_SUCCESS.getMessage() + prizeId);
    }

}
