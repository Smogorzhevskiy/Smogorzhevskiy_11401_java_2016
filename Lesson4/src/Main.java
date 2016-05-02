import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by User on 09.03.16.
 */
public class Main {
    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        Developer d = ac.getBean(Developer.class);
        d.work();
        d.learnLanguage("Java");
        d.learnLanguage("C#");

    }
}
