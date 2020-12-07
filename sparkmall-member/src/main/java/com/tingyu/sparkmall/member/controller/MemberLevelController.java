package com.tingyu.sparkmall.member.controller;


import com.tingyu.sparkmall.commons.utils.R;
import com.tingyu.sparkmall.member.param.MemberLevelParam;
import com.tingyu.sparkmall.member.service.MemberLevelService;
import com.tingyu.sparkmall.member.vo.MemberLevelVo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author essionshy
 * @Create 2020/11/29 19:06
 * @Version renren-fast
 */
@RestController
@RequestMapping("/member/level")
@Slf4j
public class MemberLevelController {

    @Resource
    private MemberLevelService memberLevelService;

    @ApiOperation("条件分页查询会员等级列表")
    @PostMapping("list/page")
    public R list(@RequestBody MemberLevelParam param) {
        Map<String, Object> map = memberLevelService.queryPage(param);
        return R.ok().put(map);
    }

    @ApiOperation("查询全部会员等级列表")
    @GetMapping("list")
    public R list() {
        List<MemberLevelVo> memberLevelVos = memberLevelService.listAll();
        return R.ok().put("items", memberLevelVos);
    }

    @ApiOperation("根据会员等级ID查询会员等级信息")
    @GetMapping("get/{id}")
    public R get(@PathVariable Integer id) {
        MemberLevelVo memberLevelVo = memberLevelService.get(id);
        return R.ok().put("item", memberLevelVo);
    }

    @ApiOperation("新增会员等级")
    @PostMapping("save")
    public R save(@RequestBody MemberLevelParam param) {

        boolean isSuccess = memberLevelService.save(param);
        if (isSuccess) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @ApiOperation("更新会员等级")
    @PostMapping("update")
    public R update(@RequestBody MemberLevelParam param) {

        boolean isSuccess = memberLevelService.update(param);
        if (isSuccess) {
            return R.ok();
        } else {
            return R.error();
        }
    }


    @ApiOperation("更新会员等级")
    @DeleteMapping("delete")
    public R delete(@RequestBody Integer[] ids) {

        boolean isSuccess = memberLevelService.removeByIds(Arrays.asList(ids));
        if (isSuccess) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @ApiOperation("会员等级分配权益")
    @PostMapping("allot/{id}")
    public R allot(@PathVariable Integer id, Integer[] rithsIds) {
        boolean isSuccess = memberLevelService.allot(id, rithsIds);
        if (isSuccess) {
            return R.ok();
        } else {
            return R.error();
        }
    }
}
