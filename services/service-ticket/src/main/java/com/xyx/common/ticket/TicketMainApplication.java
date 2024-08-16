package com.xyx.common.ticket;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.xyx"})
@MapperScan(basePackages = "com.xyx.common.ticket.mapper")
public class TicketMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(TicketMainApplication.class, args);
    }
}
