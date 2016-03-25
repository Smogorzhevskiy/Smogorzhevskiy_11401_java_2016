package Task007;

import Task007.Interface.Unit;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Unit unit1 = context.getBean(ElfScout.class);
        Unit unit2 = context.getBean(HumanGuard.class);

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


