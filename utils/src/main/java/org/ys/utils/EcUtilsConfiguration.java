package org.ys.utils;

import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class EcUtilsConfiguration {

    @Bean
    public Mapper DozerMapper() {
        return DozerBeanMapperBuilder.create().build();
    }
}