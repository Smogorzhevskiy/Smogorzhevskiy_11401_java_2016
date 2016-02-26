package Task004.Tests;

import Task004.Sword;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by User on 26.02.16.
 */
public class SwordTest {

    Sword s = new Sword();

    @Test
    public void methodShouldReturnInformationAboutWeapon(){
        String sword= s.inf_Weapon();
        String inf = "name: Gladius type: one-handed damage: 10";
        Assert.assertEquals(inf, sword);
    }

    @Test
    public void methodShouldUpWearpon(){
        s.upWeapon();
        Assert.assertTrue(15 == s.getWeaponsAttackPower());
    }

    @Test
    public void getterShouldReturnDamage(){

        Assert.assertTrue(10 == s.getWeaponsAttackPower());
    }
}
