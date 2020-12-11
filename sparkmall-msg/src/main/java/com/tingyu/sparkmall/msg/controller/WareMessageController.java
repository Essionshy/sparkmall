package com.tingyu.sparkmall.msg.controller;

import com.tingyu.sparkmall.commons.dto.WareDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存消息控制器，负责接收远程发送库存消息请求
 * @Author essionshy
 * @Create 2020/12/11 11:06
 * @Version renren-fast
 */
@RestController
@RequestMapping(value = "/msg/ware")
public class WareMessageController {


    @PostMapping("send")
    public void sendWareMessage(@RequestBody WareDTO wareDTO){

    }

}
