package com.tingyu.sparkmall.job.feign;

import com.tingyu.sparkmall.commons.dto.message.MessageLogDTO;
import com.tingyu.sparkmall.commons.support.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author essionshy
 * @Create 2020/12/14 17:11
 * @Version sparkmall
 */
@FeignClient("sparkmall-message")
public interface MessageFeignService {


    @GetMapping("/message/log/list/deliver/error")
    CommonResult<List<MessageLogDTO>> listDeliverErrorMessages();

    /**
     * 发送消息重试
     * @param
     * @return     */

    @PostMapping("/message/retry")
    CommonResult retrySendMessage(@RequestBody MessageLogDTO messageLogDTO);
}
