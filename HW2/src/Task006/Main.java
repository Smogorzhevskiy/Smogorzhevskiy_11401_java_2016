package Task006;

import Task006.Interface.Unit;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context =   new ClassPathXmlApplicationContext("/Task006/resource/spring-config.xml");
        Unit unit2 = (Unit) context.getBean("elfscout");
        Unit unit1 = (Unit) context.getBean("humanguard");

        unit1.getInformation();
        unit1.check_Invent();
        unit2.getInformation();
        unit2.check_Invent();
        unit1.useSkill();
        unit2.useSkill();
        unit1.lvlUp();
        unit2.lvlUp();
        unit1.getInformation();
        unit2.getInformation();


    }
}


