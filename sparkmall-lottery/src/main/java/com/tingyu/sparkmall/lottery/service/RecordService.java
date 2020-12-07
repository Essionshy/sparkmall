package com.tingyu.sparkmall.lottery.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.lottery.entity.RecordEntity;

import java.util.Map;


/**
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-05-11 14:20:55
 */
public interface RecordService extends IService<RecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

