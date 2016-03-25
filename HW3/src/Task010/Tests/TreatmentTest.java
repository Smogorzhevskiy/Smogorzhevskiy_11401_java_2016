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
public class TreatmentTest {
    Ability treatment;


    @Before
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        treatment = (Ability) context.getBean("treatment");
    }


    @Test

    public void getterShouldReturnDescription() {
        int d = treatment.getDescription();
        Assert.assertTrue(10 == d);
    }
}
