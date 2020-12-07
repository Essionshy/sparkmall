package com.tingyu.sparkmall.member.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.member.entity.MemberRightsEntity;
import com.tingyu.sparkmall.member.param.MemberRightsParam;
import com.tingyu.sparkmall.member.vo.MemberRightsVo;

import java.util.List;
import java.util.Map;

/**
 * @Author essionshy
 * @Create 2020/11/29 18:56
 * @Version renren-fast
 */
public interface MemberRightsService extends IService<MemberRightsEntity> {

    List<MemberRightsVo> listAll();

    MemberRightsVo get(Integer id);

    boolean save(MemberRightsParam param);

    boolean update(MemberRightsParam param);

    Map<String, Object> queryPage(MemberRightsParam param);

    List<MemberRightsVo> listByLevelId(Integer id);

    List<MemberRightsVo> buildRightsTree(Integer id);
}
