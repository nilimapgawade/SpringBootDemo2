/*package com.collection.dcoreservices.configs;

import com.collection.dcoreservices.filter.HeaderValidationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class FilterConfig {

    private final HeaderValidationFilter headerValidationFilter;

    public FilterConfig(HeaderValidationFilter headerValidationFilter) {
        this.headerValidationFilter = headerValidationFilter;
    }

    @Bean
    public FilterRegistrationBean<HeaderValidationFilter> headerValidationFilter(HeaderValidationFilter filter) {
        FilterRegistrationBean<HeaderValidationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns("/*"); // Apply to all URLs
        registrationBean.setOrder(1); // Set filter order
        return registrationBean;
    }
}
*/