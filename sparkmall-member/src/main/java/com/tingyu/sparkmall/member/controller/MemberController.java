package com.tingyu.sparkmall.member.controller;

import com.tingyu.sparkmall.commons.dto.MemberDTO;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.R;
import com.tingyu.sparkmall.member.entity.MemberEntity;
import com.tingyu.sparkmall.member.service.MemberService;
import com.tingyu.sparkmall.member.vo.MemberVo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-05-11 22:03:09
 */
@Slf4j
@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    /**
     * 列表
     */
    @ApiOperation("查询会员列表")
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        log.info("请求查询会员列表");
        PageUtils page = memberService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{userId}")
    public R info(@PathVariable("userId") Long userId) {
        MemberVo memberVo = null;
        MemberEntity member = memberService.getById(userId);
        if (member != null) {
            memberVo = new MemberVo();
            BeanUtils.copyProperties(member, memberVo);
        }
        return R.ok().put("member", memberVo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MemberEntity member) {
        memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MemberEntity member) {
        memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 远程调用
     */
    @ApiOperation("根据会员号查询会员信息")
    @GetMapping("/feign/info/{memberNo}")
    public MemberDTO getByMemberNo(@PathVariable("memberNo") String memberNo) {
        MemberDTO member = memberService.getByMemberNo(memberNo);
        return member;
    }


}
