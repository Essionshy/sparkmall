package com.tingyu.sparkmall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.ware.entity.TblWareEntity;

import java.util.Map;

/**
 * 
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:54:33
 */
public interface TblWareService extends IService<TblWareEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

