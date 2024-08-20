package com.xyx.common.user.handler.filter.user;

import com.xyx.common.config.enums.UserRegisterErrorCodeEnum;
import com.xyx.common.config.exception.ClientException;
import com.xyx.common.design.chain.AbstractChainHandler;
import com.xyx.index12306.model.user.dto.UserRegisterReqDTO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Objects;

// 验证参数必填
@Component
public class UserRegisterParamNotNullChainHandler implements UserRegisterCreateChainFilter<UserRegisterReqDTO> {
    @Override
    public void handler(UserRegisterReqDTO requestParam) {
        if (Objects.isNull(requestParam.getUsername())) {
            throw new ClientException(UserRegisterErrorCodeEnum.USER_NAME_NOTNULL);
        } else if (Objects.isNull(requestParam.getPassword())) {
            throw new ClientException(UserRegisterErrorCodeEnum.PASSWORD_NOTNULL);
        } else if (Objects.isNull(requestParam.getPhone())) {
            throw new ClientException(UserRegisterErrorCodeEnum.PHONE_NOTNULL);
        } else if (Objects.isNull(requestParam.getIdType())) {
            throw new ClientException(UserRegisterErrorCodeEnum.ID_TYPE_NOTNULL);
        } else if (Objects.isNull(requestParam.getIdCard())) {
            throw new ClientException(UserRegisterErrorCodeEnum.ID_CARD_NOTNULL);
        }
//         xxx 这里应该把所有用户注册入参校验必填，因为重复工作量所以暂时验证上述这些
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
