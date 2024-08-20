package com.xyx.common.user.handler.filter.user;

import com.xyx.common.design.chain.AbstractChainHandler;
import com.xyx.common.util.emus.UserChainMarkEnum;
import com.xyx.index12306.model.user.dto.UserRegisterReqDTO;

public interface UserRegisterCreateChainFilter<T extends UserRegisterReqDTO > extends AbstractChainHandler<UserRegisterReqDTO> {
    @Override
    default String mark() {
        return UserChainMarkEnum.USER_REGISTER_FILTER.name();
    }

}
