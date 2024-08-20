package com.xyx.common.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lfy
 * @Description
 * @create 2023-08-21 15:31
 */
@AutoConfigureAfter(RedisAutoConfiguration.class)
@Configuration
public class RedissonConfiguration {

    @Bean
    public RedissonClient redissonClient(){
        //1、创建 Config 对象
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://1.94.111.144:6379")
                .setPassword("hjltxzzzka8521")
                .setDatabase(3);

        //锁的看门狗时间。 默认 30000
//        config.setLockWatchdogTimeout()

        //2、创建 RedissonClient 对象
        RedissonClient client = Redisson.create(config);


        //Redisson 布隆过滤器
//        RBloomFilter<Object> pachong = client.getBloomFilter("pachong");
//        pachong.add("http://aaaa1.baidu.com");
//        pachong.add("http://aaaa2.baidu.com");
//        pachong.add("http://aaaa3.baidu.com");
//        pachong.add("http://aaaa4.baidu.com");
//
//        pachong.contains("http://aaaa4.baidu.com");

        return client;
    }
}
