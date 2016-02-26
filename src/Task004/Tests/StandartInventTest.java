package Task004.Tests;

import Task004.Interface.Potion;
import Task004.Interface.Weapon;
import Task004.StandartInvent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by User on 25.02.16.
 */
public class StandartInventTest {

    StandartInvent si;
    @Mock
    Weapon weapon;

    @Mock
    Potion potion;

    @Before
    public void setUp() {
        weapon = mock(Weapon.class);
        potion = mock(Potion.class);
        si = new StandartInvent(weapon, potion);
    }

    @Test

    public  void getterShouldReturnInformationAboutWeapon(){
        when(weapon.inf_Weapon()).thenReturn("Weapon: name: Gladius type: one-handed damage: 10");
        String inf0 = si.getWeapon();
        String inf1 = "Weapon: name: Gladius type: one-handed damage: 10";
        Assert.assertEquals(inf0, inf1);
    }

    @Test

    public  void getterShouldReturnInformationAboutPotion(){
        when(potion.infPotion()).thenReturn("Potion: name: PowerGod effect: +10attack");
        String inf0 = si.getPotion();
        String inf1 = "Potion: name: PowerGod effect: +10attack";
        Assert.assertEquals(inf0, inf1);
    }
}
