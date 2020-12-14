package com.tingyu.sparkmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.member.entity.MemberCollectShopEntity;

import java.util.Map;

/**
 * 关注店铺表
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-13 14:22:54
 */
public interface MemberCollectShopService extends IService<MemberCollectShopEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

