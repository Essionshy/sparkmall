package com.tingyu.sparkmall.job.task;

import com.tingyu.sparkmall.commons.dto.message.MessageLogDTO;
import com.tingyu.sparkmall.commons.support.CommonResult;
import com.tingyu.sparkmall.job.feign.MessageFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author essionshy
 * @Create 2020/12/14 17:09
 * @Version sparkmall
 */
@Service
@Slf4j
public class MessageRetryTask implements ITask {


    @Resource
    private MessageFeignService messageFeignService;


    /**
     * 定时检测发送失败的消息重新发送给 MQ
     *
     * @param params 参数，多参数使用JSON数据
     */


    @Override
    public void run(String params) {
        //远程获取发送失败的消息列表
        CommonResult<List<MessageLogDTO>> result = messageFeignService.listDeliverErrorMessages();
        if (result.getCode() == 0) {
            //请求成功
            List<MessageLogDTO> data = result.getData();
            if (data != null && data.size() > 0) {
                data.stream().forEach(message -> {
                    //重新发送消息

                    messageFeignService.retrySendMessage(message);
                });
            }

        }

    }
}
