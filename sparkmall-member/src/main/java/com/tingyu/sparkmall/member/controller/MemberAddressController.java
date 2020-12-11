package com.tingyu.sparkmall.member.controller;

import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.R;
import com.tingyu.sparkmall.member.entity.MemberAddressEntity;
import com.tingyu.sparkmall.member.service.MemberAddressService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 *
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:51:21
 */
@RestController
@RequestMapping("member/address")
public class MemberAddressController {
    @Autowired
    private MemberAddressService memberAddressService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("member:address:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberAddressService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("member:address:info")
    public R info(@PathVariable("id") Long id){
		MemberAddressEntity memberAddress = memberAddressService.getById(id);

        return R.ok().put("memberAddress", memberAddress);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("member:address:save")
    public R save(@RequestBody MemberAddressEntity memberAddress){
		memberAddressService.save(memberAddress);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("member:address:update")
    public R update(@RequestBody MemberAddressEntity memberAddress){
		memberAddressService.updateById(memberAddress);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("member:address:delete")
    public R delete(@RequestBody Long[] ids){
		memberAddressService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
