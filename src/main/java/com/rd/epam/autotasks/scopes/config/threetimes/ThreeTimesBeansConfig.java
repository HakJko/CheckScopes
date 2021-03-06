package com.rd.epam.autotasks.scopes.config.threetimes;

import com.rd.epam.autotasks.scopes.config.entity.EmployeeBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ThreeTimesBeansConfig {

    @Scope(scopeName = "threeTimes")
    @Bean("threeTimesBean1")
    public Object threeTimesBean1() {
        return EmployeeBean.getEmployee();
    }

    @Scope(scopeName = "threeTimes")
    @Bean("threeTimesBean2")
    public Object threeTimesBean2() {
        return EmployeeBean.getEmployee();
    }

}
