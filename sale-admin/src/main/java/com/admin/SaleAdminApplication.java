package com.admin;

import com.admin.config.ServiceModuleComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EntityScan(basePackages = "com.data.model.domain.entity")
@Import(ServiceModuleComponentScan.class)
public class SaleAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaleAdminApplication.class, args);
    }

}
