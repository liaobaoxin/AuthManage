package com.authmanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @date 2019/6/11 8:41
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class AuthManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthManageApplication.class,args);
    }
}
