package com.xyx.common.idempotent.aspect;

import com.xyx.common.idempotent.annotation.Idempotent;
import com.xyx.common.idempotent.factory.IdempotentExecuteHandlerFactory;
import com.xyx.common.idempotent.handler.IdempotentContext;
import com.xyx.common.idempotent.exception.RepeatConsumptionException;
import com.xyx.common.idempotent.handler.IdempotentExecuteHandler;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Aspect
public class IdempotentAspect {
    @Around("@annotation(com.xyx.common.idempotent.annotation.Idempotent)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Idempotent idempotent = getIdempotentAnnotation(joinPoint);
        IdempotentExecuteHandler instance = IdempotentExecuteHandlerFactory.getInstance(idempotent.scene(), idempotent.type());
        Object resultObj;

        try {
            instance.execute(joinPoint, idempotent);
            //5、回源：目标方法执行
            resultObj = joinPoint.proceed();//回源
            instance.postProcessing();
        } catch (RepeatConsumptionException ex) {
            /**
             * 触发幂等逻辑时可能有两种情况：
             *    * 1. 消息还在处理，但是不确定是否执行成功，那么需要返回错误，方便 RocketMQ 再次通过重试队列投递
             *    * 2. 消息处理成功了，该消息直接返回成功即可
             */
            if (!ex.getError()) {
                return null;
            }
            throw ex;
        } catch (Throwable ex) {
            // 客户端消费存在异常，需要删除幂等标识方便下次 RocketMQ 再次通过重试队列投递
            instance.exceptionProcessing();
            throw ex;
        } finally {
            IdempotentContext.clean();
        }
        return resultObj;
    }

    /**
     * 获取注解上的数据
     *
     * @param joinPoint
     * @return
     */
    public static Idempotent getIdempotentAnnotation(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        return method.getAnnotation(Idempotent.class);
    }
}
