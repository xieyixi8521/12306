package com.xyx.common.idempotent.handler.param;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONUtil;
import com.xyx.common.config.component.UserContext;
import com.xyx.common.config.exception.ClientException;
import com.xyx.common.util.tools.ReqUtil;
import com.xyx.common.idempotent.handler.AbstractIdempotentExecuteHandler;
import com.xyx.common.idempotent.handler.IdempotentContext;
import com.xyx.common.idempotent.handler.IdempotentParamWrapper;
import com.xyx.index12306.model.user.entry.TUser;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 基于方法参数验证请求幂等性
 * 公众号：马丁玩编程，回复：加群，添加马哥微信（备注：12306）获取项目资料
 */
@RequiredArgsConstructor
@Component
public class IdempotentParamExecuteHandler extends AbstractIdempotentExecuteHandler {
    @Autowired
    UserContext userContext;

    @Autowired
    RedissonClient redissonClient;
    private final static String LOCK = "lock:param:restAPI";

    @Override
    protected IdempotentParamWrapper buildWrapper(ProceedingJoinPoint joinPoint) {
        String lockKey = String.format("idempotent:path:%s:currentUserId:%s:md5:%s", getServletPath(), getCurrentUserId(), calcArgsMD5(joinPoint));
        return IdempotentParamWrapper.builder().lockKey(lockKey).joinPoint(joinPoint).build();
    }


    private String calcArgsMD5(ProceedingJoinPoint joinPoint) {
        return DigestUtil.md5Hex(JSONUtil.toJsonStr(joinPoint.getArgs()));
    }

    private Long getCurrentUserId() {
        TUser tUser = userContext.getUserAuth();
        if (tUser == null) {
            throw new ClientException("用户ID获取失败，请登录");
        }
        return tUser.getId();
    }

    private String getServletPath() {
        HttpServletRequest oldRequest = ReqUtil.getOldRequest();
        return oldRequest.getServletPath();
    }

    /**
     * 幂等处理逻辑
     */
    @Override
    public void handler(IdempotentParamWrapper wrapper) {
        String lockKey = wrapper.getLockKey();
        // 1、引入分布式锁
        RLock lock = redissonClient.getLock(lockKey);
        if (!lock.tryLock()) {
            throw new ClientException(wrapper.getIdempotent().message());
        }
        IdempotentContext.put(LOCK, lock);
    }

    /**
     * 后置处理
     */
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
    @Override
    public void exceptionProcessing() {
        postProcessing();
    }
}
