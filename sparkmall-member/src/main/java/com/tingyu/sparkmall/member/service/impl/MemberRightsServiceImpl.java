package com.tingyu.sparkmall.member.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.support.enums.DeleteStatus;
import com.tingyu.sparkmall.member.dao.MemberRightsDao;
import com.tingyu.sparkmall.member.entity.MemberRightsEntity;
import com.tingyu.sparkmall.member.param.MemberRightsParam;
import com.tingyu.sparkmall.member.service.MemberLevelRightsRelationService;
import com.tingyu.sparkmall.member.service.MemberRightsService;
import com.tingyu.sparkmall.member.vo.MemberRightsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 会员权益服务实现类
 *
 * @Author essionshy
 * @Create 2020/11/29 18:57
 * @Version renren-fast
 */
@Service
@Slf4j
public class MemberRightsServiceImpl extends ServiceImpl<MemberRightsDao, MemberRightsEntity> implements MemberRightsService {

    @Autowired
    private MemberLevelRightsRelationService memberLevelRightsRelationService;

    @Override
    public List<MemberRightsVo> listAll() {

        List<MemberRightsEntity> list = this.list();
        //校验
        if (null == list || list.size() <= 0) {
            return null;
        }
        //转换
        List<MemberRightsVo> memberRightsVos = list.stream().map(memberRightsEntity -> {
            MemberRightsVo memberRightsVo = new MemberRightsVo();
            BeanUtils.copyProperties(memberRightsEntity, memberRightsVo);
            return memberRightsVo;
        }).collect(Collectors.toList());
        return memberRightsVos;

    }

    @Override
    public MemberRightsVo get(Integer id) {

        MemberRightsEntity memberRightsEntity = this.getById(id);
        if (null == memberRightsEntity) {
            return null;
        }

        MemberRightsVo memberRightsVo = new MemberRightsVo();

        BeanUtils.copyProperties(memberRightsEntity, memberRightsVo);

        return memberRightsVo;
    }

    @Override
    public boolean save(MemberRightsParam param) {
        if (param == null) {
            return false;
        }
        MemberRightsEntity memberRightsEntity = new MemberRightsEntity();
        BeanUtils.copyProperties(param, memberRightsEntity);
        memberRightsEntity.setDeleted(DeleteStatus.UN_DELETE.ordinal());
        return this.save(memberRightsEntity);
    }

    @Override
    public boolean update(MemberRightsParam param) {
        if (param == null) {
            return false;
        }
        MemberRightsEntity memberRightsEntity = new MemberRightsEntity();
        BeanUtils.copyProperties(param, memberRightsEntity);

        return this.updateById(memberRightsEntity);
    }

    @Override
    public Map<String, Object> queryPage(MemberRightsParam param) {
        if (param == null || param.getPage() == null || param.getLimit() == null) {
            return null;
        }

        Map<String, Object> map = new HashMap<>();
        QueryWrapper<MemberRightsEntity> wrapper = new QueryWrapper<>();
        String key = param.getKey();
        //判断查询关键字

        if (key != null && !StringUtils.isEmpty(key)) {
            wrapper.like("name", key);
        }


        Page<MemberRightsEntity> page = new Page<>(param.getPage(), param.getLimit());

        baseMapper.selectPage(page, wrapper);

        long totalCount = page.getTotal();
        List<MemberRightsEntity> records = page.getRecords();

        if (records != null && records.size() > 0) {
            List<MemberRightsVo> memberLevelVos = records.stream().map(memberRightsEntity -> {

                MemberRightsVo memberRightsVo = new MemberRightsVo();
                BeanUtils.copyProperties(memberRightsEntity, memberRightsVo);
                return memberRightsVo;
            }).collect(Collectors.toList());
            map.put("total", totalCount);
            map.put("items", memberLevelVos);
        }
        return map;
    }

    @Override
    public List<MemberRightsVo> listByLevelId(Integer id) {

        List<Integer> integers = memberLevelRightsRelationService.listByLevelId(id);

        if (integers == null || integers.size() <= 0) {
            return null;
        }

        List<MemberRightsEntity> memberRightsEntities = this.listByIds(integers);
        //校验
        if (memberRightsEntities == null || memberRightsEntities.size() <= 0) {
            return null;
        }
        //转换
        List<MemberRightsVo> memberRightsVos = memberRightsEntities.stream().map(memberRightsEntity -> {
            MemberRightsVo memberRightsVo = new MemberRightsVo();

            BeanUtils.copyProperties(memberRightsEntity, memberRightsVo);
            return memberRightsVo;
        }).collect(Collectors.toList());
        return memberRightsVos;
    }

    @Override
    public List<MemberRightsVo> buildRightsTree(Integer id) {


        List<MemberRightsVo> allMemberRights = listAll();

        if (allMemberRights == null || allMemberRights.size() <= 0) {
            return null;
        }

        List<MemberRightsVo> memberRightsVos = listByLevelId(id);
        if (null != memberRightsVos && memberRightsVos.size() > 0) {
            for (int i = 0; i < allMemberRights.size(); i++) {

                MemberRightsVo memberRightsVo = allMemberRights.get(i);
                for (int j = 0; j < memberRightsVos.size(); j++) {
                    MemberRightsVo memberRights = memberRightsVos.get(j);
                    //判断
                    if (memberRightsVo.getId().equals(memberRights.getId())) {
                        memberRightsVo.setChecked(true);
                    }
                }

            }
        }


        return allMemberRights;
    }
}
