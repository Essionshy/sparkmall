package com.tingyu.sparkmall.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingyu.sparkmall.entity.lottery.PrizeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-05-11 14:20:55
 */
@Mapper
public interface PrizeDao extends BaseMapper<PrizeEntity> {

    List<PrizeEntity> findAllUnStartedPrize();

}
