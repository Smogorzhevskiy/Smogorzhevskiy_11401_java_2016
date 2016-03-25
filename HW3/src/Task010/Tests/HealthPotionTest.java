package Task010.Tests;

import Task010.Config;
import Task010.Interface.Potion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by User on 26.02.16.
 */
public class HealthPotionTest {
    Potion hp;

    @Before
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        hp = (Potion) context.getBean("healthPotion");
    }

    @Test

    public void methodShouldReturnInformationAboutPotion() {
        String p = hp.infPotion();
        String h = "name: HealthPotion effect: +10 health";
        Assert.assertEquals(h, p);

    }
}
