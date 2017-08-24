package com.zhyzhko.configuration;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by Egor on 08.04.2017.
 */
@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages = {"com.zhyzhko", "net.sf.oval.integration.spring"})
@Import(HibernateConfig.class)
@EnableTransactionManagement
public class ConfigApp {
    
}
