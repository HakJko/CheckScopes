package com.rd.epam.autotasks.scopes.config;

import com.rd.epam.autotasks.scopes.config.threetimes.ThreeTimesScopeConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Configuration
@Import(ThreeTimesScopeConfig.class)
public class ThreeTimesScopeTestConfig {

    @Bean
    @Scope("threeTimes")
    public Object threeTimesBean1() {
        return new Object();
    }

    @Bean
    @Scope("threeTimes")
    public Object threeTimesBean2() {
        return new Object();
    }

}
