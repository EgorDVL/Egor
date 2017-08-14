package com.zhyzhko.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Egor on 08.04.2017.
 */
@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages = {"com.zhyzhko", "net.sf.oval.integration.spring"})
@Import(HibernateConfig.class)
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
