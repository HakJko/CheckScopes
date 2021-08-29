package com.rd.epam.autotasks.scopes.config.justasecond;

import com.rd.epam.autotasks.scopes.config.entity.JustSecondBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JustSecondBeansConfig {

    private static int id1;
    private static int id2;

    @Scope(scopeName = "justASecond")
    @Bean("jasBean1")
    public Object getJustSecondBean1() {
        JustSecondBean bean = new JustSecondBean(id1++);
        return bean;
    }

    @Scope(scopeName = "justASecond")
    @Bean("jasBean2")
    public Object getJustSecondBean2() {
        JustSecondBean bean = new JustSecondBean(id2++);
        return bean;
    }
}
