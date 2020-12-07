package com.tingyu.sparkmall.lottery.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.dto.PrizeDTO;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.lottery.entity.PrizeEntity;

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

    List<PrizeDTO> findAllUnStartedPrize();

    boolean updateById(PrizeDTO prize);
}

