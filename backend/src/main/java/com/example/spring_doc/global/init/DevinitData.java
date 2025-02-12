package com.example.spring_doc.global.init;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DevinitData {

    @Bean
    public ApplicationRunner devApplicationRunner() {
        return args -> {
            System.out.println("dev application runner");
        };
    }

}
