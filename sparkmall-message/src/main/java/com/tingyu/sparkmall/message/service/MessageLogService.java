package com.tingyu.sparkmall.message.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.dto.message.MessageLogDTO;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.message.entity.MessageLogEntity;
import com.tingyu.sparkmall.message.vo.MessageLogVo;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-14 10:24:45
 */
public interface MessageLogService extends IService<MessageLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 修改消息状态
     * @param msg
     * @param code
     */
    void updateMessageStatus(String msg, int code);

    MessageLogVo getMessageLogById(String msgId);

    /**
     * 查询所有未发送成功的消息
     * @return
     */
    List<MessageLogDTO> listDeliverErrorMessages();
}

