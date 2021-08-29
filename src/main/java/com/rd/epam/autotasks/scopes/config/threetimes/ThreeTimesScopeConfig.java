package com.rd.epam.autotasks.scopes.config.threetimes;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.rd.epam.autotasks.scopes.config.threetimes")
public class ThreeTimesScopeConfig {

    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
        return new ThreeTimesBeanFactoryPostProcessor();
    }

}
