package Task010.Tests;

import Task010.Config;
import Task010.Interface.Potion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DamagePotionTest {
    Potion dp;

    @Before
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        dp = (Potion) context.getBean("damagePotion");
    }

    @Test

    public void methodShouldReturnInformationAboutPotion() {
        String d = dp.infPotion();
        String c = "name: PowerGod effect: +10attack";
        Assert.assertEquals(c, d);

    }
}
