package com.tingyu.sparkmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.member.entity.MemberCollectSkuEntity;

import java.util.Map;

/**
 * 关注商品表
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-13 14:22:54
 */
public interface MemberCollectSkuService extends IService<MemberCollectSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

