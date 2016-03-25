package Task004.Tests;

import Task004.HumanGuard;
import Task004.Interface.Inventory;
import Task004.Interface.Potion;
import Task004.Interface.Race;
import Task004.Interface.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;

/**
 * Created by User on 25.02.16.
 */
public class HumanGuardTest {
    HumanGuard hg;

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
        hg = new HumanGuard();
        race = mock(Race.class);
    }

    @Test
    public void methodShouldReturnCorrectInformationAboutUnit() {
        String inf0 = hg.getInformation();
        String inf1 = "warrior lvl: 1 health: 50 mana: 20 attack: 10";
        Assert.assertEquals(inf0, inf1);

    }

    @Test

    public void methodShouldImposeEffect(){

       // when(race.ability()).thenReturn(10);
       int damage = hg.useSkill();

        Assert.assertTrue(20 == damage);
    }

    @Test

    public void methodShouldReturnInfomationAboutItems(){
        String inf0 = hg.check_Invent();
        String inf1 = "Weapon: name: Gladius type: one-handed damage: 10 Potion: name: PowerGod effect: +10attack";
//        verify(inventory).getPotion();
        Assert.assertEquals(inf0, inf1);

    }


    @Test

    public void methodShouldLvlUp(){
        hg.lvlUp();
        Assert.assertEquals("warrior lvl: 2 health: 60 mana: 25 attack: 15", hg.getInformation());
    }

}
