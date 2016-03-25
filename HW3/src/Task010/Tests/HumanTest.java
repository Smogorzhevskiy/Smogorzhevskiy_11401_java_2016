package Task010.Tests;

import Task010.Config;
import Task010.Interface.Race;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HumanTest {

    Race h;

    @Before
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        h = (Race) context.getBean("human");
    }

    @Test

    public void methodShouldReturnAbility() {
        h.ability();
        Assert.assertTrue(10 == h.ability());
    }

    @Test

    public void getterShouldSumFeature() {
        String a = h.getFeature(10, 10);
        String b = "health:20 mana:15";
        System.out.print(h.getFeature(10, 10));
        Assert.assertEquals(a, b);
    }
}
