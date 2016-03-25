package Task010.Tests;

import Task010.Config;
import Task010.Interface.Unit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class HumanGuardTest {
    Unit hGuard;


    @Before
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        hGuard = (Unit) context.getBean("HumanGuard");
    }

    @Test
    public void methodShouldReturnCorrectInformationAboutUnit() {
        String inf0 = hGuard.getInformation();
        String inf1 = "warrior lvl: 1 health: 50 mana: 20 attack: 10";
        Assert.assertEquals(inf0, inf1);

    }

    @Test

    public void methodShouldImposeEffect() {

        int damage = hGuard.useSkill();

        Assert.assertTrue(10 == damage);
    }

    @Test

    public void methodShouldReturnInfomationAboutItems() {
        String inf0 = hGuard.check_Invent();
        String inf1 = "Weapon: name: Gladius type: one-handed damage: 10 Potion: name: PowerGod effect: +10attack";
        Assert.assertEquals(inf0, inf1);

    }


    @Test

    public void methodShouldLvlUp() {
        hGuard.lvlUp();
        Assert.assertEquals("warrior lvl: 2 health: 60 mana: 25 attack: 15", hGuard.getInformation());
    }

}
