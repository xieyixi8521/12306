package com.xyx.common.user.handler.filter.user;

import com.xyx.common.config.enums.UserRegisterErrorCodeEnum;
import com.xyx.common.config.exception.ClientException;
import com.xyx.common.user.service.TUserService;
import com.xyx.index12306.model.user.dto.UserRegisterReqDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// 验证用户名是否可用
@Component
@RequiredArgsConstructor
public final class UserRegisterHasUsernameChainHandler implements UserRegisterCreateChainFilter<UserRegisterReqDTO> {

    private final TUserService tUserService;

    @Override
    public void handler(UserRegisterReqDTO requestParam) {
        if (tUserService.hasUsername(requestParam.getUsername())) {
            throw new ClientException(UserRegisterErrorCodeEnum.HAS_USERNAME_NOTNULL);
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
