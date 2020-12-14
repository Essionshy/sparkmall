package com.tingyu.sparkmall.message.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.dto.message.MessageLogDTO;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.Query;
import com.tingyu.sparkmall.message.dao.MessageLogDao;
import com.tingyu.sparkmall.message.entity.MessageLogEntity;
import com.tingyu.sparkmall.message.service.MessageLogService;
import com.tingyu.sparkmall.message.utils.MessageStatusEnum;
import com.tingyu.sparkmall.message.vo.MessageLogVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("messageLogService")
public class MessageLogServiceImpl extends ServiceImpl<MessageLogDao, MessageLogEntity> implements MessageLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MessageLogEntity> page = this.page(
                new Query<MessageLogEntity>().getPage(params),
                new QueryWrapper<MessageLogEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void updateMessageStatus(String msgId, int code) {

        MessageLogEntity messageLogEntity = baseMapper.selectOne(new QueryWrapper<MessageLogEntity>().eq("msg_id", msgId));
        if (messageLogEntity == null) {
            return;
        }
        messageLogEntity.setStatus(code);
        baseMapper.updateById(messageLogEntity);
    }

    @Override
    public MessageLogVo getMessageLogById(String msgId) {
        MessageLogEntity messageLogEntity = baseMapper.selectOne(new QueryWrapper<MessageLogEntity>().eq("msg_id", msgId));

        if (null == messageLogEntity) {
            return null;
        }
        MessageLogVo messageLogVo = new MessageLogVo();
        BeanUtils.copyProperties(messageLogEntity, messageLogVo);
        messageLogVo.setStatus(MessageStatusEnum.getMessageStatusName(messageLogEntity.getStatus()));
        return messageLogVo;
    }

    @Override
    public List<MessageLogDTO> listDeliverErrorMessages() {

        List<Integer> errors = new ArrayList<>();
        errors.add(MessageStatusEnum.DELIVER_ERROR.getCode());
        errors.add(MessageStatusEnum.TO_SERVER_ERROR.getCode());
        errors.add(MessageStatusEnum.TO_QUEUE_ERROR.getCode());

        List<MessageLogEntity> entities = baseMapper.selectList(new QueryWrapper<MessageLogEntity>().in("status", errors));

        if (entities != null && entities.size() > 0) {
            List<MessageLogDTO> collect = entities.stream().map(entity -> {
                MessageLogDTO messageLogDTO = new MessageLogDTO();
                BeanUtils.copyProperties(entity,messageLogDTO);
                messageLogDTO.setStatus(MessageStatusEnum.getMessageStatusName(entity.getStatus()));
                return messageLogDTO;
            }).collect(Collectors.toList());
            return collect;
        }

        return null;
    }

}