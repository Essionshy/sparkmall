package com.tingyu.sparkmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.member.entity.MemberAddressEntity;

import java.util.Map;

/**
 * 鏀惰揣鍦板潃琛
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:51:21
 */
public interface MemberAddressService extends IService<MemberAddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

