import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by User on 04.03.16.
 */

@Configuration
@ComponentScan

public class ConfigurationLesson {

    @Bean
    public Institute KAIinstitute() {
        return new Institute("KAI");
    }

    @Bean
    @Qualifier("KFU")
    public Institute KFUinstitute() {
        return new Institute("KFU");
    }

    @Bean(name = "firstStudent")

    public Student firstStudent() {
        Student student = new Student();
        student.setName("Bob");
        student.setInstitute(KAIinstitute());
        return student;
    }

//    @Bean
//    public Student secondStudent() {
//        Student student = new Student();
//        student.setName("Max");
//        student.setInstitute(KFUinstitute());
//        return student;
//    }
}
