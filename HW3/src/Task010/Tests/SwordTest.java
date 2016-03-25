package Task010.Tests;

import Task010.Config;
import Task010.Interface.Ability;
import Task010.Interface.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwordTest {

    Weapon s;

    @Before
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        s = (Weapon) context.getBean("sword");
    }

    @Test
    public void methodShouldReturnInformationAboutWeapon() {
        String sword = s.inf_Weapon();
        String inf = "name: Gladius type: one-handed damage: 10";
        Assert.assertEquals(inf, sword);
    }

    @Test
    public void methodShouldUpWearpon() {
        s.upWeapon();
        Assert.assertTrue(15 == s.getWeaponsAttackPower());
    }

    @Test
    public void getterShouldReturnDamage() {

        Assert.assertTrue(10 == s.getWeaponsAttackPower());
    }
}
