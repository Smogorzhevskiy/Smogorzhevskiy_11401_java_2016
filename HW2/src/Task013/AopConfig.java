package Task013;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by User on 25.03.16.
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AopConfig {

    @Bean
    public User user() {
        return new User();
    }

    @Bean

    public AspectCheck check() {
        return new AspectCheck();
    }
}
