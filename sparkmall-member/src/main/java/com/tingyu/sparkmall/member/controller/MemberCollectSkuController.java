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

import com.tingyu.sparkmall.member.entity.MemberCollectSkuEntity;
import com.tingyu.sparkmall.member.service.MemberCollectSkuService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.R;



/**
 * 鍏虫敞鍟嗗搧琛
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:51:21
 */
@RestController
@RequestMapping("member/membercollectsku")
public class MemberCollectSkuController {
    @Autowired
    private MemberCollectSkuService memberCollectSkuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("member:membercollectsku:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberCollectSkuService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("member:membercollectsku:info")
    public R info(@PathVariable("id") Long id){
		MemberCollectSkuEntity memberCollectSku = memberCollectSkuService.getById(id);

        return R.ok().put("memberCollectSku", memberCollectSku);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("member:membercollectsku:save")
    public R save(@RequestBody MemberCollectSkuEntity memberCollectSku){
		memberCollectSkuService.save(memberCollectSku);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("member:membercollectsku:update")
    public R update(@RequestBody MemberCollectSkuEntity memberCollectSku){
		memberCollectSkuService.updateById(memberCollectSku);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("member:membercollectsku:delete")
    public R delete(@RequestBody Long[] ids){
		memberCollectSkuService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
