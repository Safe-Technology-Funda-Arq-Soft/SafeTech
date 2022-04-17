package com.api.safetech.technical.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("technicalMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public TechnicalMapper technicalMapper() {
        return new TechnicalMapper();
    }
}