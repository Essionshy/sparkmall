package com.tingyu.sparkmall.member.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tingyu.sparkmall.member.entity.MemberStatisticsEntity;
import com.tingyu.sparkmall.member.service.MemberStatisticsService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.R;



/**
 * 统计信息表
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-13 14:22:54
 */
@RestController
@RequestMapping("member/memberstatistics")
public class MemberStatisticsController {
    @Autowired
    private MemberStatisticsService memberStatisticsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("member:memberstatistics:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberStatisticsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("member:memberstatistics:info")
    public R info(@PathVariable("id") Long id){
		MemberStatisticsEntity memberStatistics = memberStatisticsService.getById(id);

        return R.ok().put("memberStatistics", memberStatistics);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("member:memberstatistics:save")
    public R save(@RequestBody MemberStatisticsEntity memberStatistics){
		memberStatisticsService.save(memberStatistics);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("member:memberstatistics:update")
    public R update(@RequestBody MemberStatisticsEntity memberStatistics){
		memberStatisticsService.updateById(memberStatistics);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("member:memberstatistics:delete")
    public R delete(@RequestBody Long[] ids){
		memberStatisticsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
