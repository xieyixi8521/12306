package com.atguigu.common.util.constant;

/**
 * @author lfy
 * @Description
 * @create 2023-08-21 9:40
 */
public class RedisConst {
    public static final String SKU_INFO_CACHE_KEY = "sku:info:";
    public static final String BITMAP_SKUIDS = "bitmap:skuids";
    public static final long SKU_INFO_TTL = 15 * 24 * 3600 * 1000L; //ms
    public static final String LOCK_PREFIX = "lock:";
    public static final String SKU_HOTSCORE_KEY = "sku:hotscore:";
    public static final String LOGIN_USER = "login:user:";
    public static final String LOGIN_TOKEN = "login:token:";
    public static final String LOGIN_REFRESH = "login:refresh:";
    public static final String CART_INFO = "cart:info:";

    public static final long CART_ITEM_LIMIT = 200;
    public static final long CART_ITEM_SIZE_LIMIT = 100;
    public static final String DEREPEAT_TOKEN = "derepeat:token:";
    public static final String SECKILL_GOODS_CACHE = "seckill:goods:";
    public static final String SECKILL_CODE_CACHE = "seckill:code:";
    public static final String SECKILL_ORDER_CACHE = "seckill:order:";
}
