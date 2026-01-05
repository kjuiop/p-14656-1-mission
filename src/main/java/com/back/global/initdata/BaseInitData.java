package com.back.global.initdata;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : JAKE
 * @date : 26. 1. 5.
 */
@Configuration
@Slf4j
public class BaseInitData {

    @Bean
    public ApplicationRunner baseInitDataRunner() {
        return args -> {
            log.debug("Application Runner start");
        };
    }
}
