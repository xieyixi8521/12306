package com.xyx.common.util.constant;

/**
 * @author lfy
 * @Description
 * @create 2023-09-05 11:33
 */
public class RabbitConst {
    
    public static final String EXCHANGE_ORDER_EVENT = "order-event-exchange";
    public static final String QUEUE_ORDER_CREATE = "order-create-queue";
    public static final String RK_ORDER_TIMEOUT = "order.timeout";

    public static final String RK_ORDER_CREATE = "order.create";
    public static final String QUEUE_ORDER_TIMEOUT = "order-timeout-queue";

    public static final String RK_ORDER_PAYED = "order.payed";

    public static final String QUEUE_ORDER_PAYED = "order-payed-queue";
    public static final String EXCHANGE_WARE_STOCK = "exchange.direct.ware.stock";

    public static final String RK_WARE_STOCK = "ware.stock";

    public static final String EXCHANGE_SECKILL_EVENT = "seckill-event-exchange";
    public static final String RK_SECKILL_QUEUE = "seckill.order.queue";


    public static final String QUEUE_SECKILL_QUEUE = "seckill-queue-queue";
    public static final String QUEUE_ORDER_REFUND = "order-refund-queue";
    public static final String RK_ORDER_REFUND = "order.refund";
    public static final String RK_REFUND_TIMEOUT = "refund.timeout";
    public static final String QUEUE_REFUND_TIMEOUT = "refund-timeout-queue";
}
