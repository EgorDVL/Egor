package com.zhyzhko.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Egor on 08.04.2017.
 */
@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages = "com.zhyzhko",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)})
@Import({HibernateConfig.class, WebSocketConfig.class})
@EnableTransactionManagement
public class ConfigApp {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper
                .getConfiguration()
                .setFieldAccessLevel(AccessLevel.PRIVATE)
                .setFieldMatchingEnabled(true);
        return modelMapper;
    }
}
