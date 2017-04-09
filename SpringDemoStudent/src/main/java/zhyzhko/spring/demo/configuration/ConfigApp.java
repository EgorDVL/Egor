package zhyzhko.spring.demo.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Egor on 24.02.2017.
 */
@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages = "zhyzhko.spring.demo",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)})
@Import({HibernateConfig.class, MailConfig.class})
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
