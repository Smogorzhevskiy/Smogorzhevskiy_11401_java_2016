import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Created by sentpim on 26.02.2016.
 */
public class Main {
    public static void main(String[] args) {
//        ApplicationContext ac =   new ClassPathXmlApplicationContext(   "spring-config.xml"  );
//        Student student1 = (Student) ac.getBean("Chernov");
//        Student student2 = (Student) ac.getBean("Chernov2");
//        Building building1 = (Building) ac.getBean("Main");
//        System.out.println(building1.toString());
//        System.out.println(student1.toString());
//        System.out.println(student2.toString());
//        System.out.println(student1.studentGoesToLessons());

        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationLesson.class);
        Institute institute =  context.getBean(Institute.class);
        institute.getName();
    }
}
