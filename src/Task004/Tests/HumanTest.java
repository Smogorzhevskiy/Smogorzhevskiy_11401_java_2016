package Task004.Tests;

import Task004.Human;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by User on 26.02.16.
 */
public class HumanTest {

    Human h =new Human();

    @Test

    public  void methodShouldReturnAbility(){
        h.ability();
        Assert.assertTrue(10 == h.ability());
    }

    @Test

    public void getterShouldSumFeature(){
        String a = h.getFeature(10,10);
        String b ="health:20 mana:15";
        System.out.print(h.getFeature(10,10));
        Assert.assertEquals(a, b);
    }
}
