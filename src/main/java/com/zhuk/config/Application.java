package com.zhuk.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"com.zhuk.controller","com.zhuk.service","com.zhuk.repo" })
@Import(com.zhuk.config.HibernateConfCommon.class)
public class Application {

}
