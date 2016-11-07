package com.skoryupina;

import com.skoryupina.configurations.JpaConfiguration;
import com.skoryupina.storage.StorageProperties;
import com.skoryupina.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class WebPartyProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class<?>[] {WebPartyProjectApplication.class, JpaConfiguration.class}, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
