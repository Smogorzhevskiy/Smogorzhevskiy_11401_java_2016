package Task010.Tests;

import Task010.Config;
import Task010.Interface.Race;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by User on 25.02.16.
 */
public class ElfTest {

    Race e;
    @Before
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        e = (Race)context.getBean("elf");
    }

    @Test

    public  void methodShouldReturnAbility(){
        e.ability();
        Assert.assertTrue(10 == e.ability());
    }

    @Test

    public void getterShouldSumFeature(){
        String a = e.getFeature(10,10);
        String b ="health:15 mana:20";
System.out.print(e.getFeature(10,10));
        Assert.assertEquals(a, b);
    }
}
