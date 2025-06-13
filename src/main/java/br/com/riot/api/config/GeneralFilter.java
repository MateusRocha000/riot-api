package br.com.riot.api.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralFilter {

    @Bean
    FilterRegistrationBean<FilterConfig> filters() {
        FilterRegistrationBean beans = new FilterRegistrationBean();
        beans.setFilter(new FilterConfig());
        return beans;
    }
}
