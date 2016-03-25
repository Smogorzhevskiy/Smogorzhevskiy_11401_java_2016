package Task010.Tests;

import Task010.Config;
import Task010.Interface.Inventory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StandartInventTest {

    Inventory sInvent;

    @Before
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        sInvent = (Inventory) context.getBean("sInvent");
    }

    @Test

    public void getterShouldReturnInformationAboutWeapon() {
        String inf0 = sInvent.getWeapon()[0];
        String inf1 = "name: Gladius type: one-handed damage: 10";
        Assert.assertEquals(inf0, inf1);
    }

    @Test

    public void getterShouldReturnInformationAboutPotion() {
        String inf0 = sInvent.getPotion()[0];
        String inf1 = "name: PowerGod effect: +10attack";
        Assert.assertEquals(inf0, inf1);
    }
}
