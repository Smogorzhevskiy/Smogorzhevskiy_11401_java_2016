package Task004.Tests;

import Task004.Interface.Potion;
import Task004.Interface.Weapon;
import Task004.PremiumInvent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by User on 25.02.16.
 */
public class PremiumInventTest {

    PremiumInvent pi;
    @Mock
    Weapon weapon;

    @Mock
    Potion potion;

    @Before
    public void setUp() {
        weapon = mock(Weapon.class);
        potion = mock(Potion.class);
        pi = new PremiumInvent(weapon, weapon, potion, potion );
    }

    @Test

    public  void getterShouldReturnInformationAboutWeapon(){
        when(weapon.inf_Weapon()).thenReturn("Weapon: nameBigBow type: two-handed damage: 10");
        String inf0 = pi.getWeapon();
        String inf1 = "Weapon: nameBigBow type: two-handed damage: 10";
        Assert.assertEquals(inf0, inf1);
    }

    @Test

    public  void getterShouldReturnInformationAboutPotion(){
        when(potion.infPotion()).thenReturn("Potion: name: HealthPotion effect: +10 health");
        String inf0 = pi.getPotion();
        String inf1 = "Potion: name: HealthPotion effect: +10 health";
        Assert.assertEquals(inf0, inf1);
    }
}
