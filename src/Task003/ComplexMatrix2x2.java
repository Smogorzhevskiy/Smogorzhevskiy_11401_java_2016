package Task003;

/**
 * Created by User on 23.02.16.
 */
public class ComplexMatrix2x2 {
    private ComplexNumber [][] t = new ComplexNumber[2][2];
    public ComplexMatrix2x2() {
        this(new ComplexNumber());
    }
    public ComplexMatrix2x2(ComplexNumber cn) {
        this(cn,cn,cn,cn);
    }
    public ComplexMatrix2x2(ComplexNumber z, ComplexNumber x, ComplexNumber c, ComplexNumber v) {
        this.t[0][0] = z;
        this.t[0][1] = x;
        this.t[1][0] = c;
        this.t[1][1] = v;
    }
    public ComplexMatrix2x2 add(ComplexMatrix2x2 c) {
        ComplexMatrix2x2 cm = new ComplexMatrix2x2();
        for (int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                cm.t[i][j] = this.t[i][j].add(c.t[i][j]);
            }
        }
        return cm;
    }
    public ComplexMatrix2x2 mult(ComplexMatrix2x2 cm) {
        ComplexMatrix2x2 cm2 = new ComplexMatrix2x2();
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++) {
                for ( int k = 0; k < 2; k++) {
                    cm2.t[i][j] = cm2.t[i][j].add(this.t[i][j].mult(cm.t[i][j]));
                    System.out.println(cm2.t[i][j]);
                }
            }
        }
        return cm2;
    }
    public ComplexNumber det() {
        return (this.t[0][0].mult(this.t[1][1])).sub(this.t[0][1].mult(this.t[1][0]));
    }


    public boolean equals(ComplexMatrix2x2 cm){
        if (this.get00().equals(cm.get00()) && this.get01().equals(cm.get01()) && this.get10().equals(cm.get10()) && this.get11().equals(cm.get11())){
            return true;
        }else {
            return false;
        }
    }

    public ComplexNumber get00() {
        return t[0][0];
    }

    public ComplexNumber get01() {
        return t[0][1];
    }

    public ComplexNumber get10() {
        return t[1][0];
    }

    public ComplexNumber get11() {
        return t[1][1];
    }
}
