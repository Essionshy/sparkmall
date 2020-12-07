package com.tingyu.sparkmall.lottery.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.dto.PrizeDTO;
import com.tingyu.sparkmall.commons.support.enums.LotteryStatusEnum;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.Query;
import com.tingyu.sparkmall.lottery.dao.PrizeDao;
import com.tingyu.sparkmall.lottery.entity.PrizeEntity;
import com.tingyu.sparkmall.lottery.service.PrizeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Slf4j
@Service
public class PrizeServiceImpl extends ServiceImpl<PrizeDao, PrizeEntity> implements PrizeService {

    @Autowired
    PrizeDao prizeDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<PrizeEntity> queryWrapper = new QueryWrapper<>();

        String key = (String) params.get("key");
        //如果key不为空，表示带条件的分页查询
        if (!StringUtils.isEmpty(key)) {
            queryWrapper.eq("prize_id", key).or().like("prize_level", key);
        }

        IPage<PrizeEntity> page = this.page(
                new Query<PrizeEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Override
    public void updateStatus(int code, Integer prizeId) {
        PrizeEntity prizeEntity = new PrizeEntity();
        prizeEntity.setStatus(code);
        prizeEntity.setPrizeId(prizeId);
        prizeDao.updateById(prizeEntity);
    }

    @Override
    public List<PrizeDTO> findAllUnStartedPrize() {
        QueryWrapper<PrizeEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("status", LotteryStatusEnum.UNSTART.getCode());
        wrapper.le("startTime", new Date());
        wrapper.ge("endTime", new Date());
        List<PrizeEntity> prizeEntities = prizeDao.selectList(wrapper);

        if (prizeEntities == null || prizeEntities.size() <= 0) {
            return null;
        }

        List<PrizeDTO> prizeDTOList = prizeEntities.stream().map(prizeEntity -> {
            PrizeDTO prizeDTO = new PrizeDTO();
            BeanUtils.copyProperties(prizeEntity, prizeDTO);
            return prizeDTO;
        }).collect(Collectors.toList());

        return prizeDTOList;
    }

    @Override
    public boolean updateById(PrizeDTO prize) {

        if (null == prize) {
            return false;
        }

        PrizeEntity prizeEntity = new PrizeEntity();
        BeanUtils.copyProperties(prize, prizeEntity);
        return this.updateById(prizeEntity);
    }

}