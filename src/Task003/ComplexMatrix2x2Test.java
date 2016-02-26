package Task003;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

/**
 * Created by User on 23.02.16.
 */
public class ComplexMatrix2x2Test {

    @Mock
    ComplexNumber cn;

    @Mock
    ComplexNumber cn1;

    //    public void f() {
//        when().thenReturn();
//    }
    @Before

    public void setUp() {
        cn = mock(ComplexNumber.class);
        cn1 = mock(ComplexNumber.class);


    }

//     @Ignore
    @Test
    public void sumComplexMatrixShouldBeCorrect() {
        when(cn.getI()).thenReturn(0.0);
        when(cn.getJ()).thenReturn(0.0);
        when(cn.add(cn)).thenReturn(cn);
        ComplexMatrix2x2 cm = new ComplexMatrix2x2();
        ComplexMatrix2x2 cm1 = new ComplexMatrix2x2();
        ComplexMatrix2x2 cm2 = new ComplexMatrix2x2();
        cm2 = cm.add(cm1);
        Assert.assertTrue(cm2.equals(cm1));
    }

    @Test

    public void multComplexMatrixShouldBeCorrect() {
        ComplexMatrix2x2 cm = new ComplexMatrix2x2();
        ComplexMatrix2x2 cm1 = new ComplexMatrix2x2();
        ComplexMatrix2x2 cm2 = new ComplexMatrix2x2();
        cm2= cm1.mult(cm);


        Assert.assertTrue(cm2.equals(cm));
    }
@ Ignore
    @Test

    public void detComplexMatrixShouldBeCorrect() {

        ComplexMatrix2x2 cm = new ComplexMatrix2x2();
        Assert.assertEquals(cn.getI(), cm.det());

    }

    @Test
    public  void matrixShouldBeEquals(){
        ComplexMatrix2x2 cm = new ComplexMatrix2x2();
        ComplexMatrix2x2 cm1 = new ComplexMatrix2x2();
        Assert.assertTrue(cm.equals(cm1));


    }


}
