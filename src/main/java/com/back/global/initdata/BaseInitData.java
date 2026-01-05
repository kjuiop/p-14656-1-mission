package com.back.global.initdata;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : JAKE
 * @date : 26. 1. 5.
 */
@Configuration
public class BaseInitData {

    @Bean
    public ApplicationRunner baseInitDataRunner() {
        return args -> {
            System.out.println("Application Runner start");
        };
    }
}
