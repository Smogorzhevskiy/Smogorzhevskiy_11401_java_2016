package Task010.Tests;

import Task010.Config;
import Task010.Interface.Inventory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PremiumInventTest {

    Inventory pInvent;

    @Before
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        pInvent = (Inventory) context.getBean("pInvent");
    }


    @Test

    public void getterShouldReturnInformationAboutWeapon() {
        String inf0 = pInvent.getWeapon()[1];
        String inf1 = "name: BigBow type: two-handed damage: 10";
        Assert.assertEquals(inf0, inf1);
    }

    @Test

    public void getterShouldReturnInformationAboutPotion() {

        String inf0 = pInvent.getPotion()[1];
        String inf1 = "name: HealthPotion effect: +10 health";
        Assert.assertEquals(inf0, inf1);
    }
}
