package com.tingyu.sparkmall.member.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.member.dao.MemberLevelRightsRelationDao;
import com.tingyu.sparkmall.member.entity.MemberLevelRightsRelationEntity;
import com.tingyu.sparkmall.member.service.MemberLevelRightsRelationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author essionshy
 * @Create 2020/11/29 19:49
 * @Version renren-fast
 */
@Service
@Slf4j
public class MemberLevelRightsRelationServiceImpl extends ServiceImpl<MemberLevelRightsRelationDao, MemberLevelRightsRelationEntity> implements MemberLevelRightsRelationService {


    @Override
    public List<Integer> listByLevelId(Integer id) {

        QueryWrapper<MemberLevelRightsRelationEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("level_id", id);
        wrapper.select("rights_id");

        List<MemberLevelRightsRelationEntity> entities = baseMapper.selectList(wrapper);

        if (entities == null || entities.size() <= 0) {
            return null;
        }

        List<Integer> rightsIds = new ArrayList<>();
        for (MemberLevelRightsRelationEntity entity :
                entities) {
            rightsIds.add(entity.getRightsId());

        }
        //返回数据
        return rightsIds;
    }

    @Override
    public boolean saveOrUpdate(Integer levelId, Integer[] rigthsIds) {

        if (null == rigthsIds) {
            return false;
        }
        //获取该已经拥有的会员权益
        List<Integer> rightsIds = listByLevelId(levelId);
        List<MemberLevelRightsRelationEntity> entities = new ArrayList<>();
        if (null != rightsIds) {
            for (Integer rightsId : rigthsIds) {

                if (!rightsIds.contains(rightsId)) {

                    MemberLevelRightsRelationEntity entity = new MemberLevelRightsRelationEntity();
                    entity.setLevelId(levelId);
                    entity.setRightsId(rightsId);
                    entities.add(entity);
                }
            }
        }


        return this.saveBatch(entities);
    }
}
