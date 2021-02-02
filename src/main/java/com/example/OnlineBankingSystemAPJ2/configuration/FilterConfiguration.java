package com.example.OnlineBankingSystemAPJ2.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {
    @Bean
    public FilterRegistrationBean<AuthenticationFilter> loggingFilter() {
        FilterRegistrationBean<AuthenticationFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new AuthenticationFilter());

        registrationBean.addUrlPatterns("/sign/up");

        return registrationBean;
    }
}
