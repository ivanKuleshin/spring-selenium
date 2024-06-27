package com.ivan.spring.selenium.kelvin.config;

import com.github.javafaker.Faker;
import com.ivan.spring.selenium.kelvin.annotation.LazyConfiguration;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class FakerConfig {

    @Bean
    public Faker getFaker(){
        return new Faker();
    }

}
