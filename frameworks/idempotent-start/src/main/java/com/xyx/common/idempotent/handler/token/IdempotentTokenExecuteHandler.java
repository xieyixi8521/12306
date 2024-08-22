/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xyx.common.idempotent.handler.token;

import cn.hutool.core.util.StrUtil;
import com.google.common.base.Strings;
import com.xyx.common.config.component.UserContext;
import com.xyx.common.config.errorcode.BaseErrorCode;
import com.xyx.common.config.exception.ClientException;
import com.xyx.common.idempotent.handler.AbstractIdempotentExecuteHandler;
import com.xyx.common.proxy.DistributedCache;
import com.xyx.common.idempotent.handler.IdempotentParamWrapper;
import com.xyx.common.idempotent.properties.IdempotentProperties;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 基于 Token 验证请求幂等性, 通常应用于 RestAPI 方法
 * 公众号：马丁玩编程，回复：加群，添加马哥微信（备注：12306）获取项目资料
 */
@RequiredArgsConstructor
@Component
public final class IdempotentTokenExecuteHandler extends AbstractIdempotentExecuteHandler {
    @Autowired
    DistributedCache distributedCache;
    @Autowired
    IdempotentProperties idempotentProperties;

    private static final String TOKEN_KEY = "token";
    private static final String TOKEN_PREFIX_KEY = "idempotent:token:";
    private static final long TOKEN_EXPIRED_TIME = 6;
    @Autowired
    UserContext userContext;

    @Override
    protected IdempotentParamWrapper buildWrapper(ProceedingJoinPoint joinPoint) {
        return new IdempotentParamWrapper();
    }

    public String createToken() {
        String token = Optional.ofNullable(Strings.emptyToNull(idempotentProperties.getPrefix())).orElse(TOKEN_PREFIX_KEY) + UUID.randomUUID();
        distributedCache.put(token, "", Optional.ofNullable(idempotentProperties.getTimeout()).orElse(TOKEN_EXPIRED_TIME));
        return token;
    }

    @Override
    public void handler(IdempotentParamWrapper wrapper) {
        String token = Optional.ofNullable(Strings.emptyToNull(idempotentProperties.getPrefix())).orElse(TOKEN_PREFIX_KEY) + UUID.randomUUID();
        StringRedisTemplate redisTemplate = (StringRedisTemplate) distributedCache.getInstance();
        // 锁定 Key。
        boolean success = redisTemplate.opsForValue().setIfAbsent(token, "", TOKEN_EXPIRED_TIME, TimeUnit.SECONDS);
        // 锁定失败，抛出异常
        if (success) {
            String errMsg = StrUtil.isNotBlank(wrapper.getIdempotent().message()) ? wrapper.getIdempotent().message() : BaseErrorCode.IDEMPOTENT_TOKEN_DELETE_ERROR.message();
            throw new ClientException(errMsg, BaseErrorCode.IDEMPOTENT_TOKEN_DELETE_ERROR);
        }
    }
}
