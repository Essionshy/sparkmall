package com.tingyu.sparkmall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.coupon.entity.HomeSubjectEntity;

import java.util.Map;

/**
 * 棣栭〉涓撻?琛ㄣ?jd棣栭〉涓嬮潰寰堝?涓撻?锛屾瘡涓?笓棰橀摼鎺ユ柊鐨勯〉闈?紝灞曠ず涓撻?鍟嗗搧淇℃伅銆
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:58:02
 */
public interface HomeSubjectService extends IService<HomeSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

