package Task002;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by User on 23.02.16.
 */
public class Matrix2x2Test {

  @Test

  public void constructorReceivingArrayShouldBeCorrect(){
   double [][] a = {{1,2}, {3,4}};
    Matrix2x2 m = new Matrix2x2(a);
    Matrix2x2 m1 = new Matrix2x2(1,2,3,4);
    Assert.assertTrue(m1.equals(m));

  }

  @Test

  public void constructorShouldCreateNullMatrix(){
    Matrix2x2 m = new Matrix2x2();
    Matrix2x2 m1 = new Matrix2x2(0,0,0,0);
    Assert.assertTrue(m.equals(m1));
  }

  @Test

  public  void  equalsMatrixShouldBeCorrect(){
    Matrix2x2 m = new Matrix2x2(1,1,1,1);
    Matrix2x2 m1 = new Matrix2x2(1,1,1,1);
    Assert.assertTrue(m.equals(m1));
  }

  @Test

  public  void  equalsMatrixShouldBeCorrectIfMatrixNotEquals(){
    Matrix2x2 m = new Matrix2x2(1,1,1,1);
    Matrix2x2 m1 = new Matrix2x2(1,2,1,1);
    Assert.assertFalse(m.equals(m1));
  }

  @Test

  public void getterShouldBeCorrect(){
    Matrix2x2 m = new Matrix2x2(1,2,3,4);
    Assert.assertTrue(1 == m.get00() && 2 == m.get01() && 3 == m.get10() && 4 == m.get11());
  }

  @Test

  public  void constructorShouldSaveParamsInAttribute(){
    Matrix2x2 m = new Matrix2x2(1,2,3,4);
    Assert.assertTrue(1 == m.get00() && 2 == m.get01() && 3 == m.get10() && 4 == m.get11());
  }

  @Test

  public void sumOf2MatrixsShouldBeCorrect(){
    Matrix2x2 m1 = new Matrix2x2(1,2,3,4);
    Matrix2x2 m2 = new Matrix2x2(1,2,3,4);
    Matrix2x2 m3 = new Matrix2x2(2,4,6,8);
    Matrix2x2 m4 = m1.add(m2);
    Assert.assertTrue(m3.equals(m4));

  }

  @Test

  public void sumOf2MatrixsShouldBeCorrect2(){
    Matrix2x2 m1 = new Matrix2x2(0,0,0,0);
    Matrix2x2 m2 = new Matrix2x2(1,2,3,4);
    Matrix2x2 m3 = new Matrix2x2(1,2,3,4);
    m1.add2(m2);
    Assert.assertTrue(m3.equals(m1));
  }

  @Test

  public void subOf2MatrixsShouldBeCorrect(){
    Matrix2x2 m1 = new Matrix2x2(1,2,3,4);
    Matrix2x2 m2 = new Matrix2x2(1,2,3,4);
    Matrix2x2 m3 = new Matrix2x2(0,0,0,0);
    Matrix2x2 m4 = m1.sub(m2);
    Assert.assertTrue(m3.equals(m4));

  }

  @Test

  public void subOf2MatrixsShouldBeCorrect2(){
    Matrix2x2 m1 = new Matrix2x2(2,2,2,2);
    Matrix2x2 m2 = new Matrix2x2(1,2,3,4);
    Matrix2x2 m3 = new Matrix2x2(1,0,-1,-2);
    m1.sub2(m2);
    Assert.assertTrue(m3.equals(m1));
  }

  @Test

  public void multOfNumberAndMatrixShouldBeCorrect(){
    Matrix2x2 m = new Matrix2x2(1,2,3,4);
    Matrix2x2 m1 = m.multNumber(2);
    Assert.assertTrue(2 == m1.get00() && 4 == m1.get01() && 6 == m1.get10() && 8 == m1.get11());
  }

  @Test

  public void multOfNumberAndMatrixShouldBeCorrect2(){
    Matrix2x2 m = new Matrix2x2(1,2,3,4);
    m.multNumber2(2);
    Assert.assertTrue(2 == m.get00() && 4 == m.get01() && 6 == m.get10() && 8 == m.get11());
  }

  @Test

  public void multOf2MatrixsShouldBeCorrect(){
    Matrix2x2 m = new Matrix2x2(1,2,3,4);
    Matrix2x2 m1 = new Matrix2x2(1,2,3,4);
    Matrix2x2 m2 = m.mult(m1);
    Assert.assertTrue(1 == m2.get00() && 4 == m2.get01() && 9 == m2.get10() && 16 == m2.get11());
  }

  @Test

  public void multOf2MatrixsShouldBeCorrect2(){
    Matrix2x2 m = new Matrix2x2(1,2,3,4);
    Matrix2x2 m1 = new Matrix2x2(1,2,3,4);
    m.mult2(m1);
    Assert.assertTrue(1 == m.get00() && 4 == m.get01() && 9 == m.get10() && 16 == m.get11());
  }

  @Test

  public void detMAtrixShouldBeCorrect(){
    Matrix2x2 m = new Matrix2x2(1,2,3,4);
    Assert.assertTrue(-2 == m.det());
  }

  @Test

  public void transponMatrixShouldBeCorrect(){
    Matrix2x2 m = new Matrix2x2(1,2,3,4);
    m.transpon();
    Assert.assertTrue(3 == m.get01() && 2 == m.get10());
  }


  @Test

  public void inverseMatrixShouldBeCorrect(){
    Matrix2x2 m = new Matrix2x2(1,2,3,4);
    Matrix2x2 m1= m.inverseMatrix();
    System.out.println(m1.get00() + " " + m1.get01() + " " + m1.get10() + " " + m1.get11());
    Assert.assertTrue(-2 == m1.get00() && 1.5 == m1.get01() && 1 == m1.get10() && -0.5 == m1.get11());

  }

  @Test

  public void inverseMatrixWhenDetZeroShouldBeCorrect(){
    Matrix2x2 m = new Matrix2x2(2,2,2,2);
    Matrix2x2 m1= m.inverseMatrix();
    System.out.println(m1.get00() + " " + m1.get01() + " " + m1.get10() + " " + m1.get11());

    Assert.assertTrue(m.equals(m1));

  }

  @Test

  public void equivalentDiagonalShouldBeCorrect(){
    Matrix2x2 m = new Matrix2x2(1,2,3,4);
    Matrix2x2 m1 = m.equivalentDiagonal();
    Assert.assertTrue(-6 == m1.get00() && -10 == m1.get01() && 0 == m1.get10() && 20 == m1.get11() );
  }





}
