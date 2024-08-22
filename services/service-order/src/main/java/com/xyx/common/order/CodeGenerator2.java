package com.xyx.common.order;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.xyx.base.BaseDO;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CodeGenerator2 {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://1.94.111.144:3306/12306_order_1?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&useSSL=false", "root", "123456")
                .globalConfig(builder -> builder
                        .author("Baomidou")
                        .outputDir("D:\\java\\code\\12306\\services\\service-order\\src\\main\\java")
                        .commentDate("yyyy-MM-dd")
                )
                .packageConfig(builder -> builder
                        .parent("com.xyx.common.order")
                        .entity("entity")
                        .mapper("mapper")
                        .service("service")
                        .serviceImpl("service.impl")
                        .xml("mapper.xml")
                        .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\java\\code\\12306\\services\\service-order\\src\\main\\resources\\mapper")) // 设置mapperXml生成路径
                )
                .strategyConfig(builder -> builder
                                .addTablePrefix("t_", "c_") // 增加过滤表前缀
                                .entityBuilder()
//                        .javaTemplate("/templates/entity.java") // 设置实体类模板
//                        .disable() // 禁用实体类生成
                                .superClass(BaseDO.class)
                                .addSuperEntityColumns("create_time", "update_time", "del_flag")
                                .idType(IdType.ASSIGN_ID)
                                .enableLombok()
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
