package com.ivan.spring.selenium.kelvin.scope;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThreadLocalScopeConfig {

    @Autowired
    private ConfigurableBeanFactory beanFactory;

    @PostConstruct
    public void postConstruct() {
        beanFactory.registerScope("threadLocalScope", new ThreadLocalScope());
    }

}
