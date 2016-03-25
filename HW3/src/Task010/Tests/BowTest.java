package Task010.Tests;

import Task010.Config;
import Task010.Interface.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BowTest {

    Weapon b;

    @Before
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        b = (Weapon) context.getBean("bow");
    }

    @Test
    public void methodShouldReturnInformationAboutWeapon() {
        String bow = b.inf_Weapon();
        String inf = "name: BigBow type: two-handed damage: 10";
        Assert.assertEquals(inf, bow);
    }

    @Test
    public void methodShouldUpWearpon() {
        b.upWeapon();
        Assert.assertTrue(16 == b.getWeaponsAttackPower());
    }

    @Test
    public void getterShouldReturnDamage() {

        Assert.assertTrue(10 == b.getWeaponsAttackPower());
    }
}
