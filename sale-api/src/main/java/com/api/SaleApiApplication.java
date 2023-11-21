package com.api;

import com.api.config.ServiceModuleComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EntityScan(basePackages = "com.data.model.domain.entity")
@Import(ServiceModuleComponentScan.class)
public class SaleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaleApiApplication.class, args);
    }

}
