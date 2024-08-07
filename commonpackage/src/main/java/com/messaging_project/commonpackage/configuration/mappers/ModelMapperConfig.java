package com.messaging_project.commonpackage.configuration.mappers;

import com.messaging_project.commonpackage.configuration.utils.mappers.ModelMapperManager;
import com.messaging_project.commonpackage.configuration.utils.mappers.ModelMapperService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}