package com.tingyu.sparkmall.lottery.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.Query;
import com.tingyu.sparkmall.lottery.dao.RecordDao;
import com.tingyu.sparkmall.lottery.entity.PrizeEntity;
import com.tingyu.sparkmall.lottery.entity.RecordEntity;
import com.tingyu.sparkmall.lottery.service.PrizeService;
import com.tingyu.sparkmall.lottery.service.RecordService;
import com.tingyu.sparkmall.lottery.vo.RecordVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RecordServiceImpl extends ServiceImpl<RecordDao, RecordEntity> implements RecordService {

    @Resource
    PrizeService prizeService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        String key = (String) params.get("key");
        QueryWrapper<RecordEntity> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(key)) {

            queryWrapper.like("username", key)
                    .or().like("phone", key)
                    .or().eq("record_id", key)
                    .or().eq("status", key);
        }

        IPage<RecordEntity> page = this.page(
                new Query<RecordEntity>().getPage(params),
                queryWrapper
        );

        List<RecordEntity> records = page.getRecords();
        List<RecordVO> list = records.stream().map(recordEntity -> {
            RecordVO recordVO = new RecordVO();
            BeanUtils.copyProperties(recordEntity, recordVO);
            PrizeEntity prize = prizeService.getById(recordEntity.getPrizeId());
            recordVO.setPrize(prize);
            return recordVO;
        }).collect(Collectors.toList());

        IPage<RecordVO> newPage = new Page<>();
        newPage.setRecords(list);
        newPage.setCurrent(page.getCurrent());
        newPage.setPages(page.getPages());
        newPage.setSize(page.getSize());
        newPage.setTotal(page.getTotal());
        return new PageUtils(newPage);
    }

}