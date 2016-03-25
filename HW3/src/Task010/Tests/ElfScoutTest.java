package Task010.Tests;

import Task010.Config;
import Task010.Interface.Unit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ElfScoutTest {
    Unit es;

    @Before
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        es = (Unit) context.getBean("ElfScout");
    }

    @Test
    public void methodShouldReturnCorrectInformationAboutUnit() {
        String inf0 = es.getInformation();
        String inf1 = "archer lvl: 1 health: 40 mana: 30 attack: 10";
        Assert.assertEquals(inf0, inf1);

    }

    @Test

    public void methodShouldImposeEffect() {
        int health = es.useSkill();

        Assert.assertTrue(50 == health);
    }

    @Test

    public void methodShouldReturnInfomationAboutItems() {
        String inf0 = es.check_Invent();
        String inf1 = "Weapon: name: BigBow type: two-handed damage: 10 Potion: name: HealthPotion effect: +10 health";
        Assert.assertEquals(inf0, inf1);

    }


    @Test

    public void     methodShouldLvlUp() {
        es.lvlUp();
        Assert.assertEquals("archer lvl: 2 health: 45 mana: 40 attack: 16", es.getInformation());
    }
}
