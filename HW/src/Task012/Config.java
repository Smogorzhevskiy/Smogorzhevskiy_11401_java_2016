package Task012;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by User on 24.03.16.
 */
@EnableAspectJAutoProxy
public class Config {

    @Bean
    public Injection Inj(){
        return new Injection();
    }

    @Bean
    public StopInjection SInj(){
        return new StopInjection();
    }
}
