package Task004.Tests;

import Task004.DamagePotion;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by User on 26.02.16.
 */
public class DamagePotionTest {
    DamagePotion dp = new DamagePotion();

    @Test

    public  void methodShouldReturnInformationAboutPotion(){
       String d = dp.infPotion();
        String c = "name: PowerGod effect: +10attack";
        Assert.assertEquals(c, d);

    }
}
