package com.tingyu.sparkmall.member.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.support.enums.DeleteStatus;
import com.tingyu.sparkmall.member.dao.MemberLevelDao;
import com.tingyu.sparkmall.member.entity.MemberLevelEntity;
import com.tingyu.sparkmall.member.entity.MemberLevelRightsRelationEntity;
import com.tingyu.sparkmall.member.param.MemberLevelParam;
import com.tingyu.sparkmall.member.service.MemberLevelRightsRelationService;
import com.tingyu.sparkmall.member.service.MemberLevelService;
import com.tingyu.sparkmall.member.service.MemberRightsService;
import com.tingyu.sparkmall.member.vo.MemberLevelVo;
import com.tingyu.sparkmall.member.vo.MemberRightsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author essionshy
 * @Create 2020/6/16 21:32
 * @Version renren-fast
 */
@Slf4j
@Service
public class MemberLevelServiceImpl extends ServiceImpl<MemberLevelDao, MemberLevelEntity> implements MemberLevelService {

    @Autowired
    private MemberLevelRightsRelationService memberLevelRightsRelationService;


    @Autowired
    private MemberRightsService memberRightsService;

    @Override
    public List<MemberLevelVo> listAll() {

        List<MemberLevelEntity> list = this.list();
        //校验
        if (null == list || list.size() <= 0) {
            return null;
        }
        //转换
        List<MemberLevelVo> memberLevelVos = list.stream().map(memberLevelEntity -> {
            MemberLevelVo memberLevelVo = new MemberLevelVo();
            BeanUtils.copyProperties(memberLevelEntity, memberLevelVo);
            return memberLevelVo;
        }).collect(Collectors.toList());
        return memberLevelVos;
    }

    @Override
    public MemberLevelVo get(Integer id) {

        MemberLevelEntity memberLevelEntity = this.getById(id);

        if (null == memberLevelEntity) {
            return null;
        }

        MemberLevelVo memberLevelVo = new MemberLevelVo();
        BeanUtils.copyProperties(memberLevelEntity, memberLevelVo);

        //封装 会员权益
        List<MemberRightsVo> memberRightsVos = memberRightsService.buildRightsTree(id);
        memberLevelVo.setMemberRights(memberRightsVos);
        return memberLevelVo;
    }

    @Override
    public boolean save(MemberLevelParam param) {
        if (param == null) {
            return false;
        }
        MemberLevelEntity memberLevelEntity = new MemberLevelEntity();
        BeanUtils.copyProperties(param, memberLevelEntity);
        memberLevelEntity.setDeleted(DeleteStatus.UN_DELETE.ordinal()); //设置初始删除状态为0 未删除

        //保存会员权益关系表
        memberLevelRightsRelationService.saveOrUpdate(param.getId(), param.getRithsIds());

        return this.save(memberLevelEntity);
    }

    @Override
    public boolean update(MemberLevelParam param) {
        if (param == null) {
            return false;
        }
        MemberLevelEntity memberLevelEntity = new MemberLevelEntity();
        BeanUtils.copyProperties(param, memberLevelEntity);

        memberLevelRightsRelationService.saveOrUpdate(param.getId(), param.getRithsIds());
        return this.updateById(memberLevelEntity);

    }

    @Override
    public boolean allot(Integer id, Integer[] rithsIds) {

        List<MemberLevelRightsRelationEntity> entities = new ArrayList<>();

        //校验
        if (null == rithsIds || rithsIds.length <= 0) {
            return false;
        }

        for (Integer rightsId : rithsIds) {
            MemberLevelRightsRelationEntity relationEntity = new MemberLevelRightsRelationEntity();
            relationEntity.setLevelId(id);
            relationEntity.setRightsId(rightsId);
            entities.add(relationEntity);
        }

        return memberLevelRightsRelationService.saveOrUpdateBatch(entities);
    }

    @Override
    public Map<String, Object> queryPage(MemberLevelParam param) {
        if (param == null || param.getPage() == null || param.getLimit() == null) {
            return null;
        }

        Map<String, Object> map = new HashMap<>();
        QueryWrapper<MemberLevelEntity> wrapper = new QueryWrapper<>();
        String key = param.getKey();
        //判断查询关键字

        if (key != null && !StringUtils.isEmpty(key)) {
            wrapper.like("name", key);
        }


        Page<MemberLevelEntity> page = new Page<>(param.getPage(), param.getLimit());

        baseMapper.selectPage(page, wrapper);

        long totalCount = page.getTotal();
        List<MemberLevelEntity> records = page.getRecords();

        if (records != null && records.size() > 0) {
            List<MemberLevelVo> memberLevelVos = records.stream().map(memberLevelEntity -> {

                MemberLevelVo memberLevelVo = new MemberLevelVo();
                BeanUtils.copyProperties(memberLevelEntity, memberLevelVo);
                return memberLevelVo;
            }).collect(Collectors.toList());
            map.put("total", totalCount);
            map.put("items", memberLevelVos);
        }
        return map;
    }


}
