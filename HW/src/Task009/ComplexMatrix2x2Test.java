package Task009;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by User on 23.02.16.
 */
public class ComplexMatrix2x2Test {
    ComplexNumber cn1;
    ComplexMatrix2x2 cm1;
    ComplexMatrix2x2 cm2;
    ComplexMatrix2x2 cm3;

    @Before
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        cn1 = (ComplexNumber) context.getBean("cNumber");
        cm1 = (ComplexMatrix2x2) context.getBean("cMatrix");
        cm2 = (ComplexMatrix2x2) context.getBean("cMatrix");
        cm3 = (ComplexMatrix2x2) context.getBean("cMatrix");
    }

    @Test
    public void sumComplexMatrixShouldBeCorrect() {
        cm3 = cm1.add(cm2);
        Assert.assertTrue(cm3.equals(cm1));
    }

    @Test

    public void multComplexMatrixShouldBeCorrect() {
        cm3 = cm1.mult(cm2);
        Assert.assertTrue(cm3.equals(cm1));
    }

    @Test

    public void detComplexMatrixShouldBeCorrect() {

        Assert.assertTrue(cn1.equals(cm1.det()));

    }

    @Test
    public void matrixShouldBeEquals() {
        Assert.assertTrue(cm2.equals(cm1));


    }


}
