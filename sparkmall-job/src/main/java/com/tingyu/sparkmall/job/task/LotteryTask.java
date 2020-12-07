package com.tingyu.sparkmall.job.task;

import com.google.gson.Gson;
import com.tingyu.sparkmall.commons.dto.PrizeDTO;
import com.tingyu.sparkmall.commons.support.enums.LotteryStatusEnum;
import com.tingyu.sparkmall.commons.utils.RedisKeys;
import com.tingyu.sparkmall.job.feign.PrizeFeignService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author essionshy
 * @Create 2020/5/8 18:47
 * @Version sparkmall
 */
@Slf4j
@Component
public class LotteryTask implements ITask {


    @Resource
    RedisTemplate<String, Object> redisTemplate;

    @Resource
    PrizeFeignService prizeFeignService;

    @Override
    public void run(String params) {


        List<PrizeDTO> result = prizeFeignService.findAllUnStartedPrize();

        if (null == result) {
            return;
        }

        for (PrizeDTO prize : result) {
            Integer prizeId = prize.getPrizeId();
            String prizeLevel = prize.getPrizeName();
            int amount = prize.getAmount();
            if (log.isDebugEnabled()) {
                log.debug("[{}]抽奖活动已经开始...", prizeLevel);
            }
            for (int i = 0; i < amount; i++) {
                redisTemplate.opsForList().rightPush(RedisKeys.PRIZE_KEY_PREFIX + prizeId.toString(), prizeId.toString());
            }
            if (log.isDebugEnabled()) {
                log.debug("数据迁移至Redis完成，即将执行更新抽奖状态...");
            }
            /* update lottery status*/
            updateLotteryStatus(prizeId);
            if (log.isDebugEnabled()) {
                log.debug("更新抽奖状态完成...");
            }
            /* pause task*/

        }


    }

    /**
     * 解析参数并封装成Map对象
     *
     * @param params
     * @return
     */
    private Map<String, Object> resolveParam(String params) {
        Map<String, Object> queryParams = null;
        if (!StringUtils.isEmpty(params)) {
            queryParams = new HashMap<>();
            Gson gson = new Gson();
            PrizeDTO prizeParam = gson.fromJson(params, PrizeDTO.class);
            queryParams.put("prizeId", prizeParam.getPrizeId());
            queryParams.put("page", prizeParam.getPage());
            queryParams.put("limit", prizeParam.getLimit());
            queryParams.put("status", prizeParam.getStatus());
        }
        return queryParams;
    }

    //更新抽奖状态
    public void updateLotteryStatus(Integer prizeId) {
        //修改抽奖状态为正在进行中...【0：未开始；1：正在进行中；2：已结束】

        PrizeDTO prize = new PrizeDTO();
        prize.setPrizeId(prizeId);
        prize.setStatus(LotteryStatusEnum.RUNNING.getCode());


        prizeFeignService.update(prize);
    }

}
