package com.authmanage.framework.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @date 2019/6/11 9:14
 */
@Configuration
// 指定要扫描的Mapper类的包的路径
@MapperScan({"com.authmanage.mapper","com.authmanage.generator.mapper"})
public class ApplicationConfig {

}
