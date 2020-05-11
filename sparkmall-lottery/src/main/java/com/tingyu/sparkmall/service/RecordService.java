package com.tingyu.sparkmall.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.entity.RecordEntity;
import com.tingyu.sparkmall.utils.PageUtils;

import java.util.Map;

/**
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-05-11 14:20:55
 */
public interface RecordService extends IService<RecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

