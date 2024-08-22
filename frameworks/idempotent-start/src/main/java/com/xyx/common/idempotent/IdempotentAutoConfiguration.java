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

package com.xyx.common.idempotent;

import com.xyx.common.idempotent.handler.param.IdempotentParamExecuteHandler;
import com.xyx.common.idempotent.aspect.IdempotentAspect;
import com.xyx.common.idempotent.handler.AbstractIdempotentExecuteHandler;
import com.xyx.common.idempotent.handler.sqel.IdempotentSpELByRestAPIExecuteHandler;
import com.xyx.common.idempotent.handler.token.IdempotentTokenExecuteHandler;
import com.xyx.common.idempotent.properties.IdempotentProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 幂等自动装配
 * 公众号：马丁玩编程，回复：加群，添加马哥微信（备注：12306）获取项目资料
 */
@Configuration
@EnableConfigurationProperties(IdempotentProperties.class)
public class IdempotentAutoConfiguration {

    /**
     * 幂等切面
     */
    @Bean
    public IdempotentAspect idempotentAspect() {
        return new IdempotentAspect();
    }

    /**
     * 参数方式幂等实现，基于 RestAPI 场景
     */
    @Bean
    public AbstractIdempotentExecuteHandler idempotentParamExecuteHandler() {
        return new IdempotentParamExecuteHandler();
    }

    /**
     * Token 方式幂等实现，基于 RestAPI 场景
     */
    @Bean
    public AbstractIdempotentExecuteHandler idempotentTokenExecuteHandler() {
        return new IdempotentTokenExecuteHandler();
    }

    /**
     * SpEL 方式幂等实现，基于 RestAPI 场景
     */
    @Bean
    public AbstractIdempotentExecuteHandler idempotentSpELByRestAPIExecuteHandler() {
        return new IdempotentSpELByRestAPIExecuteHandler();
    }
}
