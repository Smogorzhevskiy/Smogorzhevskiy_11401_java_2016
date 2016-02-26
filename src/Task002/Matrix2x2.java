package Task002;

/**
 * Created by User on 23.02.16.
 */
public class Matrix2x2 {
    private double w,a,s,d;
    private double[][] x = {{w,a}, {s,d}};

    public double get00() {
        return x[0][0];
    }

    public double get01() {
        return x[0][1];
    }

    public double get10() {
        return x[1][0];
    }

    public double get11() {
        return x[1][1];
    }

    public Matrix2x2() {
        this(0,0,0,0);
    }
    public Matrix2x2(double[][] w) {
        this(w[0][0],w[0][1],w[1][0],w[1][1]);
    }
    public Matrix2x2(double a, double b, double c, double d) {
        this.x [0][0] = a;
        this.x [0][1] = b;
        this.x [1][0] = c;
        this.x [1][1] = d;
    }
    public Matrix2x2 add(Matrix2x2 v){
        Matrix2x2 v2 = new Matrix2x2(this.x[0][0] + v.x[0][0], this.x[0][1] + v.x[0][1], this.x[1][0] + v.x[1][0], this.x[1][1] + v.x[1][1]);
        return v2;
    }
    public void add2(Matrix2x2 v) {
        this.x[0][0]+= v.x[0][0];
        this.x[0][1]+= v.x[0][1];
        this.x[1][0]+= v.x[1][0];
        this.x[1][1]+= v.x[1][1];
    }
    public Matrix2x2 sub(Matrix2x2 v) {
        Matrix2x2 v2 = new Matrix2x2(this.x[0][0] - v.x[0][0], this.x[0][1] - v.x[0][1], this.x[1][0] - v.x[1][0], this.x[1][1] - v.x[1][1]);
        return v2;
    }
    public void sub2(Matrix2x2 v){
        this.x[0][0]-= v.x[0][0];
        this.x[0][1]-= v.x[0][1];
        this.x[1][0]-= v.x[1][0];
        this.x[1][1]-= v.x[1][1];
    }
    public Matrix2x2 multNumber(double d) {
        Matrix2x2 v2 = new Matrix2x2(this.x[0][0] * d, this.x[0][1] * d, this.x[1][0] * d, this.x[1][1] * d);
        return v2;
    }
    public void multNumber2(double d) {
        this.x[0][0]*= d;
        this.x[0][1]*= d;
        this.x[1][0]*= d;
        this.x[1][1]*= d;
    }
    public Matrix2x2 mult(Matrix2x2 v){
        Matrix2x2 v2 = new Matrix2x2(this.x[0][0] * v.x[0][0], this.x[0][1] * v.x[0][1], this.x[1][0] * v.x[1][0], this.x[1][1] * v.x[1][1]);
        return v2;
    }
    public void mult2(Matrix2x2 v){
        this.x[0][0]*= v.x[0][0];
        this.x[0][1]*= v.x[0][1];
        this.x[1][0]*= v.x[1][0];
        this.x[1][1]*= v.x[1][1];
    }
    public double det() {
        double d;
        d = ((this.x[0][0] * this.x[1][1]) - (this.x[0][1] * this.x[1][0]));
        return d;
    }
    public void transpon() {
        double t;
        t = this.x[0][1];
        this.x[0][1] = this.x[1][0];
        this.x[1][0] = t;
    }
    public Matrix2x2 inverseMatrix() {
        Matrix2x2 m = new Matrix2x2();
        double d = det();
        if(d != 0) {
            m.x[0][0] = x[1][1];
            m.x[0][1] = -x[1][0];
            m.x[1][0] = -x[0][1];
            m.x[1][1] = x[0][0];
            d = 1/d;
            m.multNumber2(d);
            transpon();
            return  m;
        } else {
            return this;
        }
    }
    public Matrix2x2 equivalentDiagonal() {
        Matrix2x2 m = new Matrix2x2();
        m.x[0][0] = x[0][0] * x[1][0];
        m.x[0][1] = x[0][1] * x[1][0];
        m.x[1][0] = x[1][0] * x[0][0];
        m.x[1][1] = x[1][1] * x[0][0];
        m.x[1][0] = m.x[1][0] - m.x[0][0];
        m.x[1][1] = m.x[1][1] - m.x[0][1];
        m.x[0][0] = m.x[0][0] * m.x[1][1];
        m.x[0][1] = m.x[0][1] * m.x[1][1];
        m.x[0][1] = m.x[0][1] - m.x[1][1];
        m.x[1][1] = m.x[1][1] * m.x[0][1];
        return m;
    }

    public boolean equals(Matrix2x2 m){
        if (this.get00() == m.get00() && this.get01() == m.get01() && this.get10() == m.get10() && this.get11() == m.get11()) {
            return true;
        } else {
          return false;
        }
    }




}
