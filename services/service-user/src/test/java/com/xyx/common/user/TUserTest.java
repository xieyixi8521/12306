package com.xyx.common.user;

import cn.hutool.core.util.IdUtil;
import com.xyx.common.service.BitmapService;
import com.xyx.common.user.service.TUserService;
import com.xyx.index12306.model.user.entry.TUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TUserTest {
    @Autowired
    TUserService tUserService;
    @Autowired
    BitmapService bitmapService;

    @Test
    void test01() {
        for (int i = 0; i < 10; i++) {
            TUser tUser = new TUser();
            tUser.setUsername("hahaha2:" + i);
            tUser.setPassword("1213124");
            tUser.setRealName("hahah1");
            tUser.setId(IdUtil.getSnowflakeNextId());
            tUserService.save(tUser);
        }
    }

    @Test
    void test02() {
        boolean contains = bitmapService.contains("bitmap:username", 427168256L);
        System.out.println("是否正确："+contains);
    }
}
