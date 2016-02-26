package Task004.Tests;

import Task004.Bow;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by User on 26.02.16.
 */
public class BowTest {

    Bow b = new Bow();

    @Test
    public void methodShouldReturnInformationAboutWeapon(){
        String bow= b.inf_Weapon();
        String inf = "nameBigBow type: two-handed damage: 10";
        Assert.assertEquals(inf, bow);
    }

    @Test
    public void methodShouldUpWearpon(){
        b.upWeapon();
        Assert.assertTrue(16 == b.getWeaponsAttackPower());
    }

    @Test
    public void getterShouldReturnDamage(){

        Assert.assertTrue(10 == b.getWeaponsAttackPower());
    }
}
