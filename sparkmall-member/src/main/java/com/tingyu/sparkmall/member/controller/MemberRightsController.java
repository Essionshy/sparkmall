package com.tingyu.sparkmall.member.controller;


import com.tingyu.sparkmall.commons.utils.R;
import com.tingyu.sparkmall.member.param.MemberRightsParam;
import com.tingyu.sparkmall.member.service.MemberRightsService;
import com.tingyu.sparkmall.member.vo.MemberRightsVo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 会员权益控制器类
 *
 * @Author essionshy
 * @Create 2020/11/29 19:06
 * @Version renren-fast
 */
@RestController
@RequestMapping("/member/rights")
@Slf4j
public class MemberRightsController {

    @Resource
    private MemberRightsService memberRightsService;

    @ApiOperation("条件分页查询会员权益列表")
    @PostMapping("list/page")
    public R list(@RequestBody MemberRightsParam param) {
        Map<String, Object> map = memberRightsService.queryPage(param);
        return R.ok().put(map);
    }

    @ApiOperation("查询全部会员权益 列表")
    @GetMapping("list")
    public R list() {
        List<MemberRightsVo> memberRightsVos = memberRightsService.listAll();
        return R.ok().put("items", memberRightsVos);
    }

    @ApiOperation("根据会员权益 ID查询会员权益 信息")
    @GetMapping("get/{id}")
    public R get(@PathVariable Integer id) {
        MemberRightsVo memberRightsVos = memberRightsService.get(id);
        return R.ok().put("item", memberRightsVos);
    }

    @ApiOperation("新增会员权益 ")
    @PostMapping("save")
    public R save(@RequestBody MemberRightsParam param) {

        boolean isSuccess = memberRightsService.save(param);
        if (isSuccess) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @ApiOperation("更新会员权益 ")
    @PutMapping("update")
    public R update(@RequestBody MemberRightsParam param) {

        boolean isSuccess = memberRightsService.update(param);
        if (isSuccess) {
            return R.ok();
        } else {
            return R.error();
        }
    }


    @ApiOperation("更新会员权益 ")
    @DeleteMapping("delete")
    public R delete(@RequestBody Integer[] ids) {
        boolean isSuccess = memberRightsService.removeByIds(Arrays.asList(ids));
        if (isSuccess) {
            return R.ok();
        } else {
            return R.error();
        }
    }
}
