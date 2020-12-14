package com.tingyu.sparkmall.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.dto.seckill.SeckillSessionDTO;
import com.tingyu.sparkmall.commons.dto.seckill.SeckillSkuDTO;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.Query;
import com.tingyu.sparkmall.coupon.dao.SeckillSessionDao;
import com.tingyu.sparkmall.coupon.entity.SeckillSessionEntity;
import com.tingyu.sparkmall.coupon.service.SeckillSessionService;
import com.tingyu.sparkmall.coupon.service.SeckillSkuService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("seckillSessionService")
public class SeckillSessionServiceImpl extends ServiceImpl<SeckillSessionDao, SeckillSessionEntity> implements SeckillSessionService {

    @Resource
    private SeckillSkuService seckillSkuService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SeckillSessionEntity> page = this.page(
                new Query<SeckillSessionEntity>().getPage(params),
                new QueryWrapper<SeckillSessionEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<SeckillSessionDTO> listLatest3DaysSessions() {
        List<SeckillSessionEntity> entities = baseMapper.selectList(new QueryWrapper<SeckillSessionEntity>().between("start_time", startTime(), endTime()));

        if (entities != null && entities.size() > 0) {
            List<SeckillSessionDTO> collect = entities.stream().map(seckillSessionEntity -> {
                SeckillSessionDTO seckillSessionDTO = new SeckillSessionDTO();
                BeanUtils.copyProperties(seckillSessionEntity, seckillSessionDTO);

                //根据场次ID查询秒杀商品列表
                List<SeckillSkuDTO> seckillSkuDTOS = seckillSkuService.listBySessionId(seckillSessionEntity.getId());
                seckillSessionDTO.setSeckillItems(seckillSkuDTOS);
                return seckillSessionDTO;
            }).collect(Collectors.toList());
            return collect;
        }

        return null;
    }

    private String endTime() {
        LocalDate now = LocalDate.now();
        LocalDate localDate = now.plusDays(2);
        LocalDateTime of = LocalDateTime.of(localDate, LocalTime.MAX);
        String format = of.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return format;
    }

    private String startTime() {
        LocalDate now = LocalDate.now();
        LocalDateTime of = LocalDateTime.of(now, LocalTime.MIN);
        String format = of.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return format;
    }

}