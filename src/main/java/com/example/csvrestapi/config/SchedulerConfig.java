/**
 * This file contains the configuration for the scheduler in the CSV REST API project.
 * It enables scheduling and logs the state of the configuration upon initialization.
 */
package com.example.csvrestapi.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@Slf4j
public class SchedulerConfig {

    @PostConstruct
    private void logSchedulerConfigState() {
        log.info("SchedulerConfig is enabled");
    }
}
