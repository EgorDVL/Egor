package zhyzhko.bruteforce.test.task.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.mvc.Controller;


/**
 * Created by Egor on 22.05.2017.
 */

@Configuration
@ComponentScan(basePackages = "zhyzhko.bruteforce.test.task",
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)})
public class ConfigApp {

}
