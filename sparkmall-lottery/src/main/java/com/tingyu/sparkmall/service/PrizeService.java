package com.tingyu.sparkmall.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.entity.lottery.PrizeEntity;
import com.tingyu.sparkmall.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-05-11 14:20:55
 */
public interface PrizeService extends IService<PrizeEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateStatus(int code, Integer prizeId);

    List<PrizeEntity> findAllUnStartedPrize();
}

