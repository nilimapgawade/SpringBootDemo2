package com.collection.dcoreservices.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class AppConfig {

    @Bean
    ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    
    
 /*   @Bean
    HeaderValidationFilter getHeaderValidationFilter() {
        return new HeaderValidationFilter();
    }
    
    */
}
