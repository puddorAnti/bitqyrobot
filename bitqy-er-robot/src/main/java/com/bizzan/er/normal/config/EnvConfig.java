package com.bizzan.er.normal.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA 19.0.1
 *
 * @DESCRIPTION: EnvConfig
 * @Author liqingping
 * @Date 2019-11-25 9:46
 */
@Component
@Data
@Slf4j
public class EnvConfig {

    @Value("${spring.profiles.active}")
    private String env;
    @Value("${spring.application.name}")
    private String serviceName;
    @Value("${domain:192.168.0.22:8801}")
    private String domain;

    public static String ACTIVE;
    public static String DOMAIN;

    @PostConstruct
    public void init() {
        ACTIVE = env;
        DOMAIN = domain;
    }

    public static boolean isDev() {
        return "dev".equalsIgnoreCase(ACTIVE);
    }

    public static boolean isTest() {
        return "test".equalsIgnoreCase(ACTIVE);
    }

    public static boolean isProd() {
        return "prod".equalsIgnoreCase(ACTIVE);
    }

    public static boolean isDefault() {
        return "default".equalsIgnoreCase(ACTIVE);
    }

}
