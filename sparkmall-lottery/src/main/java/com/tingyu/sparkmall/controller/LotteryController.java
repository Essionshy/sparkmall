package com.tingyu.sparkmall.controller;

import com.tingyu.sparkmall.param.LotteryParam;
import com.tingyu.sparkmall.service.LotteryService;
import com.tingyu.sparkmall.support.CommonResult;
import com.tingyu.sparkmall.support.enums.BizCodeEnum;
import com.tingyu.sparkmall.utils.R;
import com.tingyu.sparkmall.validator.Assert;
import com.tingyu.sparkmall.vo.MemberVo;
import com.tingyu.sparkmall.vo.RecordVO;
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


    // @SysLog
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
     * @param memberVo
     * @return
     */
    @PostMapping("register")
    public R register(@RequestBody MemberVo memberVo) {
        boolean isSuccess = lotteryService.register(memberVo);
        return R.ok().put("isSuccess", isSuccess);
    }

    /**
     * 根据抽奖等级随机抽奖
     *
     * @param
     * @return
     */
    @PostMapping("get")
    public R randomLottery(@RequestBody LotteryParam param) {

        List<RecordVO> recordVOList = lotteryService.randomLottery(param);

        return R.ok().put("records", recordVOList);

    }

}
