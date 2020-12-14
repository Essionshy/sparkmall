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
 * 收货地址表
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-13 14:22:54
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
