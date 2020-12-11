package com.tingyu.sparkmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.member.entity.MemberCollectSkuEntity;

import java.util.Map;

/**
 * 鍏虫敞鍟嗗搧琛
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:51:21
 */
public interface MemberCollectSkuService extends IService<MemberCollectSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

