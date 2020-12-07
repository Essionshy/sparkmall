package com.tingyu.sparkmall.lottery.controller;

import com.tingyu.sparkmall.commons.dto.PrizeDTO;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.R;
import com.tingyu.sparkmall.lottery.entity.PrizeEntity;
import com.tingyu.sparkmall.lottery.service.PrizeService;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/lottery/prize")
public class PrizeController {
    @Autowired
    private PrizeService prizeService;

    /**
     * 列表
     */
    @ApiOperation("条件分页查询奖项列表")
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {

        PageUtils page = prizeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("根据奖项ID查询奖项信息")
    @RequestMapping("/info/{prizeId}")
    public R info(@PathVariable("prizeId") Integer prizeId) {
        PrizeEntity prize = prizeService.getById(prizeId);

        return R.ok().put("prize", prize);
    }

    /**
     * 保存
     */
    @ApiOperation("设置奖项信息")
    @RequestMapping("/save")
    public R save(@RequestBody PrizeEntity prize) {
        prizeService.save(prize);

        return R.ok();
    }

    /**
     * 修改
     */
    @ApiOperation("更新奖项信息")
    @RequestMapping("/update")
    public R update(@RequestBody PrizeDTO prize) {
        prizeService.updateById(prize);

        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation("删除奖项信息")
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] prizeIds) {
        prizeService.removeByIds(Arrays.asList(prizeIds));
        return R.ok();
    }

    /**
     * 查找所有未启动的抽奖项
     *
     * @return
     */
    @ApiOperation("查询全部未执行奖项信息列表")
    @RequestMapping("/find/all")
    public List<PrizeDTO> findAllUnStartedPrize() {
        List<PrizeDTO> list = prizeService.findAllUnStartedPrize();
        return list;
    }
}
