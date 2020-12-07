package com.tingyu.sparkmall.commons.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author essionshy
 * @Create 2020/11/28 23:58
 * @Version renren-fast
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private static final float LOADFACTOR = 0.75F;
    private int capactity;

    /**
     * @param capactity 初始化容量
     * @param //访问顺序    accessOrder
     * @param capactity
     */
    public LRUCache(int capactity) {
        super(capactity, LOADFACTOR, true);
        this.capactity = capactity;
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return super.size() > capactity;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, "a");
        lruCache.put(2, "c");
        lruCache.put(3, "b");
        System.out.println(lruCache.keySet().toString());
        lruCache.put(4, "d");
        System.out.println(lruCache.keySet().toString());
        lruCache.put(3, "c");
        System.out.println(lruCache.keySet().toString());
        lruCache.put(3, "c");
        System.out.println(lruCache.keySet().toString());
        lruCache.put(3, "c");
        System.out.println(lruCache.keySet().toString());
        lruCache.put(5, "g");
        System.out.println(lruCache.keySet().toString());

    }

}
