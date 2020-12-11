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

import com.tingyu.sparkmall.member.entity.MemberAddressEntity;
import com.tingyu.sparkmall.member.service.MemberAddressService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.R;



/**
 * 鏀惰揣鍦板潃琛
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:51:21
 */
@RestController
@RequestMapping("member/memberaddress")
public class MemberAddressController {
    @Autowired
    private MemberAddressService memberAddressService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("member:memberaddress:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberAddressService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("member:memberaddress:info")
    public R info(@PathVariable("id") Long id){
		MemberAddressEntity memberAddress = memberAddressService.getById(id);

        return R.ok().put("memberAddress", memberAddress);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("member:memberaddress:save")
    public R save(@RequestBody MemberAddressEntity memberAddress){
		memberAddressService.save(memberAddress);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("member:memberaddress:update")
    public R update(@RequestBody MemberAddressEntity memberAddress){
		memberAddressService.updateById(memberAddress);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("member:memberaddress:delete")
    public R delete(@RequestBody Long[] ids){
		memberAddressService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
