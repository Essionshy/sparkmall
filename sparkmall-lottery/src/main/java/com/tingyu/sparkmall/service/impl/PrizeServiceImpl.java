package com.tingyu.sparkmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.dao.PrizeDao;
import com.tingyu.sparkmall.entity.lottery.PrizeEntity;
import com.tingyu.sparkmall.service.PrizeService;
import com.tingyu.sparkmall.support.enums.LotteryStatusEnum;
import com.tingyu.sparkmall.utils.PageUtils;
import com.tingyu.sparkmall.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("prizeService")
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
    public List<PrizeEntity> findAllUnStartedPrize() {
        QueryWrapper<PrizeEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("status", LotteryStatusEnum.UNSTART.getCode());
        wrapper.le("startTime", new Date());
        wrapper.ge("endTime", new Date());
        return prizeDao.selectList(wrapper);
    }

}