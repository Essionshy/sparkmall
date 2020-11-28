package com.tingyu.sparkmall.controller;

import com.tingyu.sparkmall.entity.lottery.PrizeEntity;
import com.tingyu.sparkmall.service.PrizeService;
import com.tingyu.sparkmall.utils.PageUtils;
import com.tingyu.sparkmall.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-05-11 14:20:55
 */
@RestController
@RequestMapping("lottery/prize")
public class PrizeController {
    @Autowired
    private PrizeService prizeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {

        PageUtils page = prizeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{prizeId}")
    public R info(@PathVariable("prizeId") Integer prizeId) {
        PrizeEntity prize = prizeService.getById(prizeId);

        return R.ok().put("prize", prize);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PrizeEntity prize) {
        prizeService.save(prize);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PrizeEntity prize) {
        prizeService.updateById(prize);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] prizeIds) {
        prizeService.removeByIds(Arrays.asList(prizeIds));
        return R.ok();
    }

    /**
     * 查找所有未启动的抽奖项
     * @return
     */
    @RequestMapping("/find/all")
    public R findAllUnStartedPrize(){
        List<PrizeEntity> list = prizeService.findAllUnStartedPrize();
        return R.ok().put("list",list);
    }
}
