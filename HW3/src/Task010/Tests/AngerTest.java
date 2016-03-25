package Task010.Tests;

import Task010.Config;
import Task010.Interface.Ability;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by User on 25.02.16.
 */
public class AngerTest {

    Ability a;

    @Before
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        a = (Ability) context.getBean("anger");
    }


    @Test

    public void getterShouldReturnDescription() {
        int d = a.getDescription();
        Assert.assertTrue(10 == d);
    }
}
