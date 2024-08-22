package com.xyx.common.idempotent.handler.sqel;

import com.xyx.common.config.exception.ClientException;
import com.xyx.common.idempotent.handler.AbstractIdempotentExecuteHandler;
import com.xyx.common.idempotent.annotation.Idempotent;
import com.xyx.common.idempotent.aspect.IdempotentAspect;
import com.xyx.common.idempotent.handler.IdempotentContext;
import com.xyx.common.idempotent.handler.IdempotentParamWrapper;
import com.xyx.common.idempotent.toolkit.SpELUtil;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 基于 SpEL 方法验证请求幂等性，适用于 RestAPI 场景
 * 公众号：马丁玩编程，回复：加群，添加马哥微信（备注：12306）获取项目资料
 */
@RequiredArgsConstructor
@Component
public class IdempotentSpELByRestAPIExecuteHandler extends AbstractIdempotentExecuteHandler {
    @Autowired
    RedissonClient redissonClient;
    private final static String LOCK = "lock:spEL:restAPI";

    @Override
    protected IdempotentParamWrapper buildWrapper(ProceedingJoinPoint joinPoint) {
        Idempotent idempotent = IdempotentAspect.getIdempotentAnnotation(joinPoint);
        String key = (String) SpELUtil.parseKey(idempotent.key(), ((MethodSignature) joinPoint.getSignature()).getMethod(), joinPoint.getArgs());
        return IdempotentParamWrapper.builder().lockKey(key).joinPoint(joinPoint).build();
    }

    /**
     * 执行逻辑
     *
     * @param wrapper 幂等参数包装器
     */
    @Override
    public void handler(IdempotentParamWrapper wrapper) {
        String uniqueKey = wrapper.getIdempotent().uniqueKeyPrefix() + wrapper.getLockKey();
        RLock lock = redissonClient.getLock(uniqueKey);
        if (!lock.tryLock()) {
            throw new ClientException(wrapper.getIdempotent().message());
        }
        IdempotentContext.put(LOCK, lock);
    }

    @Override
    public void exceptionProcessing() {
        postProcessing();
    }

    @Override
    public void postProcessing() {
        RLock lock = null;
        try {
            lock = (RLock) IdempotentContext.getKey(LOCK);
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
    }
}
