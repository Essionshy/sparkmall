package com.tingyu.sparkmall.ware.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingyu.sparkmall.ware.entity.WareEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author essionshy
 * @Create 2020/11/27 23:18
 * @Version renren-fast
 */

public interface WareMapper extends BaseMapper<WareEntity> {

    @Select("select * from tbl_ware where product_no =#{productNo}")
    WareEntity getByProductNo(@Param("productNo") String productNo);
}
