package com.tingyu.sparkmall.lottery.controller;

import com.tingyu.sparkmall.commons.dto.MemberDTO;
import com.tingyu.sparkmall.commons.support.CommonResult;
import com.tingyu.sparkmall.commons.support.enums.BizCodeEnum;
import com.tingyu.sparkmall.commons.utils.R;
import com.tingyu.sparkmall.commons.validator.Assert;
import com.tingyu.sparkmall.lottery.param.LotteryParam;
import com.tingyu.sparkmall.lottery.service.LotteryService;
import com.tingyu.sparkmall.lottery.vo.RecordVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author essionshy
 * @Create 2020/5/8 12:24
 * @Version sparkmall
 */
@RestController
@RequestMapping(value = "lottery")
public class LotteryController {

    @Resource
    LotteryService lotteryService;


    @ApiOperation("开始抽奖")
    @PostMapping("start")
    public CommonResult lottery(@RequestBody LotteryParam param) {
        Assert.isNull(param, BizCodeEnum.NULL_POINTER_EXCEPTION.getMessage());
        //验证当前请求是否合法
        Integer prizeId = lotteryService.lottery(param);
        return new CommonResult(BizCodeEnum.LOTTERY_SUCCESS.getCode(), BizCodeEnum.LOTTERY_SUCCESS.getMessage() + prizeId);
    }

    /**
     * 抽奖活动报名
     *
     * @param member
     * @return
     */
    @ApiOperation("抽奖活动报名入口")
    @PostMapping("register")
    public R register(@RequestBody MemberDTO member) {
        boolean isSuccess = lotteryService.register(member);
        return R.ok().put("isSuccess", isSuccess);
    }

    /**
     * 根据抽奖等级随机抽奖
     *
     * @param
     * @return
     */
    @ApiOperation("随机抽奖")
    @PostMapping("get")
    public R randomLottery(@RequestBody LotteryParam param) {

        List<RecordVO> recordVOList = lotteryService.randomLottery(param);

        return R.ok().put("records", recordVOList);

    }

}
