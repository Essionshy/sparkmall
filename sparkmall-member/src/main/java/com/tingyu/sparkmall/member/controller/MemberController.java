package com.tingyu.sparkmall.member.controller;

import com.tingyu.sparkmall.commons.dto.MemberDTO;
import com.tingyu.sparkmall.commons.support.CommonResult;
import com.tingyu.sparkmall.commons.support.enums.BizCodeEnum;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.R;
import com.tingyu.sparkmall.member.entity.MemberEntity;
import com.tingyu.sparkmall.member.exception.MemberNotFoundException;
import com.tingyu.sparkmall.member.exception.PasswordNotMatchedException;
import com.tingyu.sparkmall.member.exception.PhoneExistsException;
import com.tingyu.sparkmall.member.exception.UsernameExistsException;
import com.tingyu.sparkmall.member.param.MemberLoginParam;
import com.tingyu.sparkmall.member.param.MemberRegisterParam;
import com.tingyu.sparkmall.member.service.MemberService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 会员控制器
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:51:21
 */
@RestController
@RequestMapping("member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("member:member:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("member:member:info")
    public R info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("member:member:save")
    public R save(@RequestBody MemberEntity member){
		memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("member:member:update")
    public R update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("member:member:delete")
    public R delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 远程调用服务以及主业务逻辑
     */
    @ApiOperation("会员注册")
    @PostMapping("register")
    public CommonResult register(@RequestBody MemberRegisterParam param){

       try{

           memberService.register(param);
           return CommonResult.success();
       }catch (Exception e){

           //用户名已存在异常
           if(e instanceof UsernameExistsException){

               return CommonResult.error(BizCodeEnum.REGISTER_USERNAME_EXISTS.getCode(),
                       BizCodeEnum.REGISTER_USERNAME_EXISTS.getMessage());
           }
           //手机号已存在异常
           if(e instanceof PhoneExistsException){
               return CommonResult.error(BizCodeEnum.REGISTER_USERNAME_EXISTS.getCode(),
                       BizCodeEnum.REGISTER_USERNAME_EXISTS.getMessage());
           }
            //返回未知异常
           return CommonResult.error(BizCodeEnum.UNKNOWN_EXCEPTION.getCode(),
                   BizCodeEnum.UNKNOWN_EXCEPTION.getMessage());

       }
    }

    @PostMapping("login")
    public CommonResult<MemberDTO> login(@RequestBody MemberLoginParam param){


        try{

            MemberDTO loginUser = memberService.login(param);
            return CommonResult.success().setData(loginUser);
        }catch (Exception e){

            //用户名已存在异常
            if(e instanceof MemberNotFoundException){

                return CommonResult.error(BizCodeEnum.LOGIN_USER_NOT_FOUND.getCode(),
                        BizCodeEnum.LOGIN_USER_NOT_FOUND.getMessage());
            }
            //手机号已存在异常
            if(e instanceof PasswordNotMatchedException){
                return CommonResult.error(BizCodeEnum.LOGIN_PASSWORD_NOT_MATCHED.getCode(),
                        BizCodeEnum.LOGIN_PASSWORD_NOT_MATCHED.getMessage());
            }
            //返回未知异常
            return CommonResult.error(BizCodeEnum.UNKNOWN_EXCEPTION.getCode(),
                    BizCodeEnum.UNKNOWN_EXCEPTION.getMessage());

        }


    }

}
