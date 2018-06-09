package springmvc.intro.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springmvc.intro.repositories.TicketPersistedDao;
import springmvc.intro.services.TicketsDaoBasedService;

@Configuration
@ComponentScan(basePackageClasses = {
    TicketPersistedDao.class,
    TicketsDaoBasedService.class
})
public class AppConfig {

}
