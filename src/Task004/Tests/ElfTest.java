package Task004.Tests;

import Task004.Elf;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by User on 25.02.16.
 */
public class ElfTest {

    Elf e =new Elf();

    @Test

    public  void methodShouldReturnAbility(){
        e.ability();
        Assert.assertTrue(10 == e.ability());
    }

    @Test

    public void getterShouldSumFeature(){
        String a = e.getFeature(10,10);
        String b ="health:15 mana:20";
System.out.print(e.getFeature(10,10));
        Assert.assertEquals(a, b);
    }
}
