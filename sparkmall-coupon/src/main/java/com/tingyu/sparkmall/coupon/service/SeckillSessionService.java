package com.tingyu.sparkmall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.dto.seckill.SeckillSessionDTO;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.coupon.entity.SeckillSessionEntity;

import java.util.List;
import java.util.Map;

/**
 * 秒杀活动场次
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-13 14:21:15
 */
public interface SeckillSessionService extends IService<SeckillSessionEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询最近3天秒杀活动场次列表
     * @return
     */
    List<SeckillSessionDTO> listLatest3DaysSessions();
}

