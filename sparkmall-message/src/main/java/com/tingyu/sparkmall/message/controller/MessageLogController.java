package com.tingyu.sparkmall.message.controller;

import com.tingyu.sparkmall.commons.dto.message.MessageLogDTO;
import com.tingyu.sparkmall.commons.support.CommonResult;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.R;
import com.tingyu.sparkmall.message.entity.MessageLogEntity;
import com.tingyu.sparkmall.message.service.MessageLogService;
import com.tingyu.sparkmall.message.vo.MessageLogVo;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-14 10:24:45
 */
@RestController
@RequestMapping("message/log")
public class MessageLogController {
    @Autowired
    private MessageLogService messageLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("message:messagelog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = messageLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		MessageLogEntity messageLog = messageLogService.getById(id);

        return R.ok().put("messageLog", messageLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("message:messagelog:save")
    public R save(@RequestBody MessageLogEntity messageLog){
		messageLogService.save(messageLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("message:messagelog:update")
    public R update(@RequestBody MessageLogEntity messageLog){
		messageLogService.updateById(messageLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("message:messagelog:delete")
    public R delete(@RequestBody Long[] msgIds){
		messageLogService.removeByIds(Arrays.asList(msgIds));

        return R.ok();
    }

    @ApiOperation("根据消息ID查询消息详细信息")
    @GetMapping("get/info/{msgId}")
    public R getMessageLogByMsgId(@PathVariable("msgId")String msgId){
        MessageLogVo messageLog = messageLogService.getMessageLogById(msgId);
        return R.ok().put("messageLog",messageLog);
    }

    /**
     * 远程调用方法
     */

    @ApiOperation("查询所有发送失败的消息")
    @GetMapping("list/deliver/error")
    public CommonResult< List<MessageLogDTO>> listDeliverErrorMessages(){

        List<MessageLogDTO> messages=messageLogService.listDeliverErrorMessages();
        return CommonResult.success().setData(messages);
    }

}
