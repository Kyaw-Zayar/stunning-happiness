package com.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.data")
@PropertySource("classpath:database.properties")
public class ServiceModuleComponentScan {
}
