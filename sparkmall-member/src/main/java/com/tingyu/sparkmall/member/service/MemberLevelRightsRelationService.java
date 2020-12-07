package com.tingyu.sparkmall.member.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.member.entity.MemberLevelRightsRelationEntity;

import java.util.List;

/**
 * @Author essionshy
 * @Create 2020/11/29 18:57
 * @Version renren-fast
 */
public interface MemberLevelRightsRelationService extends IService<MemberLevelRightsRelationEntity> {
    List<Integer> listByLevelId(Integer id);

    boolean saveOrUpdate(Integer levelId, Integer[] rithsIds);


}
