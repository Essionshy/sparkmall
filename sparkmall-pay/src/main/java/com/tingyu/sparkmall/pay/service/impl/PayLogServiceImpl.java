package com.tingyu.sparkmall.pay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.pay.entity.PayLogEntity;
import com.tingyu.sparkmall.pay.mapper.PayLogMapper;
import com.tingyu.sparkmall.pay.service.PayLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author essionshy
 * @Create 2020/12/2 20:59
 * @Version renren-fast
 */
@Service
@Slf4j
public class PayLogServiceImpl extends ServiceImpl<PayLogMapper, PayLogEntity> implements PayLogService {
}
