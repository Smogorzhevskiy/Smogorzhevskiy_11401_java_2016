package Task009;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by User on 21.03.16.
 */
@Configuration
@ComponentScan
public class Config {
    @Bean
    public ComplexNumber cNumber(){
        return new ComplexNumber();
    }

    @Bean

    public ComplexMatrix2x2 cMatrix(){
        return new ComplexMatrix2x2();
    }

}
