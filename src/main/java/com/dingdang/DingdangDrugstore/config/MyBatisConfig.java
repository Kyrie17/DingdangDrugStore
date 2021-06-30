package com.dingdang.DingdangDrugstore.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/1/15 19:32
 *
 * MyBatis配置类
 */

@Configuration
@MapperScan("com.dingdang.DingdangDrugstore.mbg.mapper")
public class MyBatisConfig {
}
