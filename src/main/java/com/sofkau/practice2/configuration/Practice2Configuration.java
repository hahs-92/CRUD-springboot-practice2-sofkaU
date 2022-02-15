package com.sofkau.practice2.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Practice2Configuration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

