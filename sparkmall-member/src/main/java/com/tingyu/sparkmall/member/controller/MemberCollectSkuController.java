package com.tingyu.sparkmall.member.controller;

import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.R;
import com.tingyu.sparkmall.member.entity.MemberCollectSkuEntity;
import com.tingyu.sparkmall.member.service.MemberCollectSkuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 会员关注商品控制器类
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:51:21
 */
@RestController
@RequestMapping("member/collectsuk")
public class MemberCollectSkuController {
    @Autowired
    private MemberCollectSkuService memberCollectSkuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("member:collectsuk:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberCollectSkuService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("member:collectsku:info")
    public R info(@PathVariable("id") Long id){
		MemberCollectSkuEntity memberCollectSku = memberCollectSkuService.getById(id);

        return R.ok().put("memberCollectSku", memberCollectSku);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("member:collectsku:save")
    public R save(@RequestBody MemberCollectSkuEntity memberCollectSku){
		memberCollectSkuService.save(memberCollectSku);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("member:collectsku:update")
    public R update(@RequestBody MemberCollectSkuEntity memberCollectSku){
		memberCollectSkuService.updateById(memberCollectSku);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("member:collectsku:delete")
    public R delete(@RequestBody Long[] ids){
		memberCollectSkuService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
