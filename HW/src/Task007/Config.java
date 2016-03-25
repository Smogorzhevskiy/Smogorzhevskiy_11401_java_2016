package Task007;

import Task007.Interface.Unit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by User on 19.03.16.
 */
@Configuration
@ComponentScan("Task007")
public class Config {
    @Bean
    public Unit ElfScout() {
        return new ElfScout();
    }

    @Bean
    public Unit HumanGuard() {
        return new HumanGuard();
    }
}
