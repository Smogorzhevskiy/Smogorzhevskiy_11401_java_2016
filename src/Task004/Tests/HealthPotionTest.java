package Task004.Tests;

import Task004.HealthPotion;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by User on 26.02.16.
 */
public class HealthPotionTest {
HealthPotion hp = new HealthPotion();
    @Test

    public  void methodShouldReturnInformationAboutPotion(){
        String p = hp.infPotion();
        String h = "name: HealthPotion effect: +10 health";
        Assert.assertEquals(h,p);

    }
}
