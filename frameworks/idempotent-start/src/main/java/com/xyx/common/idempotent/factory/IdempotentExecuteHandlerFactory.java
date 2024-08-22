package com.xyx.common.idempotent.factory;

import com.xyx.common.design.factory.ApplicationContextHolder;
import com.xyx.common.idempotent.handler.AbstractIdempotentExecuteHandler;
import com.xyx.common.idempotent.handler.param.IdempotentParamExecuteHandler;
import com.xyx.common.idempotent.handler.sqel.IdempotentSpELByRestAPIExecuteHandler;
import com.xyx.common.util.emus.IdempotentSceneEnum;
import com.xyx.common.util.emus.IdempotentTypeEnum;
import com.xyx.common.idempotent.handler.token.IdempotentTokenExecuteHandler;


public class IdempotentExecuteHandlerFactory {

    /**
     * 获取幂等执行处理器
     * @param scene 指定幂等验证场景类型
     * @param type  指定幂等处理类型
     * @return 幂等执行处理器
     */
    public static AbstractIdempotentExecuteHandler getInstance(IdempotentSceneEnum scene, IdempotentTypeEnum type) {
        AbstractIdempotentExecuteHandler result = null;
        switch (scene) {
            case RESTAPI -> {
                switch (type) {
                    case PARAM -> result = ApplicationContextHolder.getBean(IdempotentParamExecuteHandler.class);
                    case TOKEN -> result = ApplicationContextHolder.getBean(IdempotentTokenExecuteHandler.class);
                    case SPEL -> result = ApplicationContextHolder.getBean(IdempotentSpELByRestAPIExecuteHandler.class);
                    default -> {
                    }
                }
            }
//            case MQ -> result = ApplicationContextHolder.getBean(IdempotentSpELByMQExecuteHandler.class);
            default -> {
            }
        }
        return result;
    }
}
