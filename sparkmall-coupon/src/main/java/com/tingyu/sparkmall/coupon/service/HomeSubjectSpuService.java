package com.tingyu.sparkmall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.coupon.entity.HomeSubjectSpuEntity;

import java.util.Map;

/**
 * 涓撻?鍟嗗搧
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:58:02
 */
public interface HomeSubjectSpuService extends IService<HomeSubjectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

