package Task004.Tests;

import Task004.ElfScout;
import Task004.Interface.Inventory;
import Task004.Interface.Potion;
import Task004.Interface.Race;
import Task004.Interface.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

/**
 * Created by User on 26.02.16.
 */
public class ElfScoutTest {
    ElfScout es;

    @Mock
    Weapon weapon;

    @Mock
    Potion potion;

    @Mock
    Race race;

    @Mock
    Inventory inventory;

    @Before
    public void setUp() {
        es = new ElfScout();
    }

    @Test
    public void methodShouldReturnCorrectInformationAboutUnit() {
        String inf0 = es.getInformation();
        String inf1 = "archer lvl: 1 health: 40 mana: 30 attack: 10";
        Assert.assertEquals(inf0, inf1);

    }

    @Test

    public void methodShouldImposeEffect(){
        int health = es.useSkill();

        Assert.assertTrue(50 == health);
    }

    @Test

    public void methodShouldReturnInfomationAboutItems(){
        String inf0 = es.check_Invent();
        String inf1 = "Weapon: nameBigBow type: two-handed damage: 10 Potion: name: HealthPotion effect: +10 health";
//        verify(inventory).getPotion();
        Assert.assertEquals(inf0, inf1);

    }


    @Test

    public void methodShouldLvlUp(){
        es.lvlUp();
        Assert.assertEquals("archer lvl: 2 health: 45 mana: 40 attack: 16", es.getInformation());
    }
}
