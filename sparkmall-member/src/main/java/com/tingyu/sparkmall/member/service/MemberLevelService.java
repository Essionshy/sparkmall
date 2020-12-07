package com.tingyu.sparkmall.member.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.member.entity.MemberLevelEntity;
import com.tingyu.sparkmall.member.param.MemberLevelParam;
import com.tingyu.sparkmall.member.vo.MemberLevelVo;

import java.util.List;
import java.util.Map;

/**
 * @Author essionshy
 * @Create 2020/6/16 21:31
 * @Version renren-fast
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {
    List<MemberLevelVo> listAll();

    MemberLevelVo get(Integer id);

    boolean save(MemberLevelParam param);

    boolean update(MemberLevelParam param);

    /**
     * 给会员等级分配会员权益
     *
     * @param id
     * @param rithsIds
     * @return
     */
    boolean allot(Integer id, Integer[] rithsIds);

    Map<String, Object> queryPage(MemberLevelParam param);
}
