package com.xyx.common.user.handler.filter.user;

import com.xyx.common.config.exception.ClientException;
import com.xyx.common.user.service.TUserService;
import com.xyx.index12306.model.user.dto.UserRegisterReqDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// 验证证件号是否多次注销，如果是的话加入黑名单
@Component
@RequiredArgsConstructor
public final class UserRegisterCheckDeletionChainHandler implements UserRegisterCreateChainFilter<UserRegisterReqDTO> {

    private final TUserService userService;

    @Override
    public void handler(UserRegisterReqDTO requestParam) {
        Integer userDeletionNum = userService.queryUserDeletionNum(requestParam.getIdType(), requestParam.getIdCard());
        if (userDeletionNum >= 5) {
            throw new ClientException("证件号多次注销账号已被加入黑名单");
        }
    }

    @Override
    public int getOrder() {
        return 2;
    }
}