package Task004.Tests;

import Task004.Treatment;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by User on 25.02.16.
 */
public class TreatmentTest {
    Treatment a = new Treatment();


    @Test

    public  void getterShouldReturnDescription(){
        int d = a.getDescription();
        Assert.assertTrue(10 == d);
    }
}
