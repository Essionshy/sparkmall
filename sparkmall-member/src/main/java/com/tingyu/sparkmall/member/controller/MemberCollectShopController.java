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

import com.tingyu.sparkmall.member.entity.MemberCollectShopEntity;
import com.tingyu.sparkmall.member.service.MemberCollectShopService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.R;



/**
 * 鍏虫敞搴楅摵琛
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:51:21
 */
@RestController
@RequestMapping("member/membercollectshop")
public class MemberCollectShopController {
    @Autowired
    private MemberCollectShopService memberCollectShopService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("member:membercollectshop:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberCollectShopService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("member:membercollectshop:info")
    public R info(@PathVariable("id") Long id){
		MemberCollectShopEntity memberCollectShop = memberCollectShopService.getById(id);

        return R.ok().put("memberCollectShop", memberCollectShop);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("member:membercollectshop:save")
    public R save(@RequestBody MemberCollectShopEntity memberCollectShop){
		memberCollectShopService.save(memberCollectShop);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("member:membercollectshop:update")
    public R update(@RequestBody MemberCollectShopEntity memberCollectShop){
		memberCollectShopService.updateById(memberCollectShop);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("member:membercollectshop:delete")
    public R delete(@RequestBody Long[] ids){
		memberCollectShopService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
