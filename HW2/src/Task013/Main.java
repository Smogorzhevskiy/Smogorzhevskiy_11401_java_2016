package Task013;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        String name = "Logan";
        String mail = "xmen@gmail.com";
        ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        User user = context.getBean(User.class);
        user.setName(name);
        user.setMail(mail);
    }
}
