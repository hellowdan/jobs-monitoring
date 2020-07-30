package org.jboss.qa.monitoring.health.application;

import org.jboss.qa.monitoring.health.controller.HealthDashboardController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses= HealthDashboardController.class)
public class HealthDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(HealthDashboardApplication.class, args);
    }
}
