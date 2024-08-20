package com.xyx.common.service.impl;

import com.xyx.common.service.BitmapService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BitmapServiceImpl implements BitmapService {
    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public boolean contains(String bitmapKey, Long offset) {
        Boolean bit = false;
        try {
            bit = redisTemplate.opsForValue().getBit(bitmapKey, offset);
        } catch (Exception e) {
            log.warn("居然超范围攻击我，以为我不知道...");
            bit = false; //位图没有数据
        }

        return bit;
    }

    @Override
    public void setbit(String bitmapKey, Long offset, boolean b) {
        redisTemplate.opsForValue().setBit(bitmapKey, offset, b);
    }
}
