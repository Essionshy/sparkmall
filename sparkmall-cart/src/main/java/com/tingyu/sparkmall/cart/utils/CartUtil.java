package com.tingyu.sparkmall.cart.utils;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author essionshy
 * @Create 2020/12/2 15:23
 * @Version renren-fast
 */
public final class CartUtil {


    public static Integer getValueForInt(Map<String, Object> entries, String target) {
        Iterator<Map.Entry<String, Object>> iterator = entries.entrySet().iterator();
        Integer count = 0;
        while (iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();
            String key = next.getKey();
            if (key.contains(target)) {
                count = Math.addExact(count, (Integer) next.getValue());
            }
        }
        return count;
    }

    public static BigDecimal getValueForBigDecimal(Map<String, Object> entries, String target) {
        Iterator<Map.Entry<String, Object>> iterator = entries.entrySet().iterator();
        BigDecimal count = new BigDecimal(0);
        while (iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();
            String key = next.getKey();
            if (key.contains(target)) {
                count = count.add(new BigDecimal((Double) next.getValue()));
            }
        }
        return count;
    }


}
