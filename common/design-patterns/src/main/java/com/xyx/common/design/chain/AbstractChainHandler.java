package com.xyx.common.design.chain;

import org.springframework.core.Ordered;

public interface AbstractChainHandler<T> extends Ordered {
    /**
     * 执行责任链逻辑
     */
    void handler(T requestParam);
    /**
     * @return 责任链组件标识
     */
    String mark();
}
